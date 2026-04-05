package org.akgulb.app.service.miniedu.course.mapper;

import org.akgulb.app.service.miniedu.course.dto.CourseDTO;
import org.akgulb.app.service.miniedu.course.dto.CoursesDTO;
import com.beratak.course.data.entity.Course;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "CourseMapperImpl", componentModel = "spring")
public interface ICourseMapper {
    CourseDTO toCourseDTO(Course course);

    default CoursesDTO toCoursesDTO(List<CourseDTO> courses) {
        var dto = new CoursesDTO();

        dto.courses = courses;

        return dto;
    }
}
