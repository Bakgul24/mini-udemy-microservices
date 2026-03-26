package org.berat.app.service.miniedu.user.mapper;

import com.bakgul.user.data.entity.User;
import org.berat.app.service.miniedu.user.dto.UserDTO;
import org.berat.app.service.miniedu.user.dto.UsersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "UserMapperImpl", componentModel = "spring")
public interface IUserMapper {
    UserDTO toUserDto(User user);

    default UsersDTO toUsersDto(List<UserDTO> users) {
        var dto = new UsersDTO();

        dto.users = users;

        return dto;
    }
}
