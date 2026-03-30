package org.berat.app.service.miniedu.user.service;

import com.bakgul.user.data.dal.UserPostServiceHelper;
import com.bakgul.user.data.entity.dto.UserSaveDTO;
import com.bakgul.user.data.entity.enums.Role;
import com.miniedu.exception.common.InvalidInputException;
import com.miniedu.exception.common.DuplicateResourceException;
import com.miniedu.exception.common.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.berat.app.service.miniedu.user.event.TeacherCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value(("${kafka.topic}"))
    private String kafkaTopic;
    private final UserPostServiceHelper m_userServiceHelper;

    private final KafkaTemplate<String, TeacherCreatedEvent> kafkaTemplate;

    public UserService(UserPostServiceHelper userServiceHelper,
                       KafkaTemplate<String, TeacherCreatedEvent> kafkaTemplate) {
        this.m_userServiceHelper = userServiceHelper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public UserSaveDTO saveUser(UserSaveDTO userDto) {
        if (userDto == null) {
            throw InvalidInputException.nullField("userDto");
        }

        if (userDto.getEmail() == null || userDto.getEmail().trim().isEmpty()) {
            throw InvalidInputException.nullField("email");
        }

        if (userDto.getFirstName() == null || userDto.getFirstName().trim().isEmpty()) {
            throw InvalidInputException.nullField("name");
        }

        if (!userDto.getEmail().contains("@")) {
            throw InvalidInputException.invalidFormat("email", "example@domain.com");
        }

        try {
            UserSaveDTO savedUser = m_userServiceHelper.saveUser(userDto);

            if (savedUser.getRole() == Role.TEACHER) {
                TeacherCreatedEvent event = new TeacherCreatedEvent();
                event.setUserId(savedUser.getId());
                event.setEmail(savedUser.getEmail());
                event.setMiddleName(savedUser.getMiddleName());
                event.setFirstName(savedUser.getFirstName());
                event.setLastName(savedUser.getLastName());

                kafkaTemplate.send(kafkaTopic, event);
                System.out.println("TeacherCreatedEvent published for userId: " + savedUser.getId());
            }

            return savedUser;

        } catch (Exception ex) {
            if (ex.getMessage() != null && ex.getMessage().contains("email")) {
                throw DuplicateResourceException.withEmail("User", userDto.getEmail());
            }
            throw new com.miniedu.exception.common.InternalServerException("Failed to save user", ex);
        }
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw InvalidInputException.nullField("email");
        }

        if (!email.contains("@")) {
            throw InvalidInputException.invalidFormat("email", "example@domain.com");
        }

        try {

            m_userServiceHelper.deleteByEmail(email);
        } catch (Exception ex) {
            if (ex.getMessage() != null && ex.getMessage().contains("not found")) {
                throw ResourceNotFoundException.byEmail("User", email);
            }
            throw new com.miniedu.exception.common.InternalServerException("Failed to delete user", ex);
        }
    }
}