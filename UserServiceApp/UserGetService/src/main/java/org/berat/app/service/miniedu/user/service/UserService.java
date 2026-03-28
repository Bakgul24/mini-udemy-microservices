package org.berat.app.service.miniedu.user.service;

import com.bakgul.user.data.dal.UserGetServiceHelper;
import com.bakgul.user.data.entity.User;
import com.bakgul.user.data.entity.enums.Role;
import com.miniedu.exception.common.ResourceNotFoundException;
import com.miniedu.exception.common.InvalidInputException;
import org.berat.app.service.miniedu.user.dto.UserDTO;
import org.berat.app.service.miniedu.user.dto.UserExistsDTO;
import org.berat.app.service.miniedu.user.dto.UsersDTO;
import org.berat.app.service.miniedu.user.mapper.IUserMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private final UserGetServiceHelper m_userServiceHelper;
    private final IUserMapper m_userMapper;

    public UserService(UserGetServiceHelper userServiceHelper, IUserMapper userMapper) {
        m_userServiceHelper = userServiceHelper;
        m_userMapper = userMapper;
    }


    public Optional<UserDTO> findByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw InvalidInputException.nullField("email");
        }

        return m_userServiceHelper.findByEmail(email)
                .map(m_userMapper::toUserDto)
                .or(() -> {
                    throw ResourceNotFoundException.byEmail("User", email);
                });
    }

    public UsersDTO findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw InvalidInputException.nullField("name");
        }

        Iterable<User> usersIterable = m_userServiceHelper.findByName(name);

        var usersDtoList = StreamSupport.stream(usersIterable.spliterator(), false)
                .map(m_userMapper::toUserDto)
                .collect(Collectors.toList());

        if (usersDtoList.isEmpty()) {
            throw ResourceNotFoundException.byName("User", name);
        }
        return m_userMapper.toUsersDto(usersDtoList);
    }

    public UserExistsDTO existsUserById(int id) {
        if (id <= 0) {
            throw InvalidInputException.invalidRange("id", "greater than 0");
        }
        boolean exists = m_userServiceHelper.existsUserById(id);
        return new UserExistsDTO(exists);
    }

    public UsersDTO findByRole(Role role) {
        Iterable<User> usersIterable = m_userServiceHelper.findByRole(role);

        var usersDtoList = StreamSupport.stream(usersIterable.spliterator(), false)
                .map(m_userMapper::toUserDto)
                .collect(Collectors.toList());

        return m_userMapper.toUsersDto(usersDtoList);
    }
}