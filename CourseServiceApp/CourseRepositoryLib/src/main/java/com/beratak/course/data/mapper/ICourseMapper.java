package com.beratak.course.data.mapper;

import com.beratak.course.data.entity.Course;
import com.beratak.course.data.entity.dto.CourseSave;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CourseMapperImpl", componentModel = "spring")
public interface ICourseMapper {
    Course toCourse(CourseSave courseSave);
}
