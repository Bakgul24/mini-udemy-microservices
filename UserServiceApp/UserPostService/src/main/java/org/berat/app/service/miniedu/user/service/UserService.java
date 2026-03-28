package org.berat.app.service.miniedu.user.service;

import com.bakgul.user.data.dal.UserPostServiceHelper;
import com.bakgul.user.data.entity.dto.UserSaveDTO;
import com.miniedu.exception.common.InvalidInputException;
import com.miniedu.exception.common.DuplicateResourceException;
import com.miniedu.exception.common.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserPostServiceHelper m_userServiceHelper;

    public UserService(UserPostServiceHelper userServiceHelper) {
        m_userServiceHelper = userServiceHelper;
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
            return m_userServiceHelper.saveUser(userDto);
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