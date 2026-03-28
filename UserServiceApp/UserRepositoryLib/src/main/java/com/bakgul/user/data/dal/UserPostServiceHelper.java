package com.bakgul.user.data.dal;

import com.bakgul.user.data.entity.User;
import com.bakgul.user.data.entity.dto.UserSaveDTO;
import com.bakgul.user.data.repository.IUserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UserPostServiceHelper {
    private final IUserRepository m_userRepository;

    public UserPostServiceHelper(IUserRepository userRepository) {
        m_userRepository = userRepository;
    }

    private void updateUserFromDto(UserSaveDTO userDto, User userEntity) {
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setMiddleName(userDto.getMiddleName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());
    }

    @Transactional
    public UserSaveDTO saveUser(UserSaveDTO userDto) {
        User userEntity = m_userRepository.findById(userDto.getId())
                .orElse(new User());

        updateUserFromDto(userDto, userEntity);
        m_userRepository.save(userEntity);

        userDto.setId(userEntity.getId());
        return userDto;
    }
}
