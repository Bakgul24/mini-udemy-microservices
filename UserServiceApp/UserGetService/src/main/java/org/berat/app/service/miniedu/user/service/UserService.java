package org.berat.app.service.miniedu.user.service;

import com.bakgul.user.data.dal.UserServiceHelper;
import com.bakgul.user.data.entity.User;
import org.berat.app.service.miniedu.user.dto.UserDTO;
import org.berat.app.service.miniedu.user.dto.UserExistsDTO;
import org.berat.app.service.miniedu.user.dto.UsersDTO;
import org.berat.app.service.miniedu.user.mapper.IUserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private final UserServiceHelper m_userServiceHelper;
    private final IUserMapper m_userMapper;

    public UserService(UserServiceHelper userServiceHelper, IUserMapper mUserMapper) {
        m_userServiceHelper = userServiceHelper;
        m_userMapper = mUserMapper;
    }

    public Optional<UserDTO> findByEmail(String email) {
        return m_userServiceHelper.findByEmail(email).map(m_userMapper::toUserDto);
    }

    public UsersDTO findByName(String name) {
        Iterable<User> usersIterable = m_userServiceHelper.findByName(name);

        List<UserDTO> usersDtoList = StreamSupport.stream(usersIterable.spliterator(), false)
                .map(m_userMapper::toUserDto)
                .collect(Collectors.toList());

        return m_userMapper.toUsersDto(usersDtoList);
    }

    public UserExistsDTO existsUserById(int id) {
        return new UserExistsDTO(m_userServiceHelper.existsUserById(id));
    }
}

