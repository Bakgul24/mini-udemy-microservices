package org.akgul.app.service.miniedu.teacher.mapper;

import com.akgulberat.teacher.data.entity.Teacher;
import org.akgul.app.service.miniedu.teacher.dto.TeacherDTO;
import org.akgul.app.service.miniedu.teacher.dto.TeachersDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "TeacherMapperImpl", componentModel = "spring")
public interface ITeacherMapper {
    TeacherDTO toTeacherDTO(Teacher teacher);
    default TeachersDTO toUsersDto(List<TeacherDTO> teachers) {
        var dto = new TeachersDTO();

        dto.teachers = teachers;
        return dto;
    }
}
