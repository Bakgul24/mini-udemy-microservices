package org.akgulb.app.service.miniedu.course.mapper;

import org.akgulb.app.service.miniedu.course.dto.CourseSaveDTO;
import com.beratak.course.data.entity.dto.CourseSave;
import org.mapstruct.Mapper;

@Mapper(implementationName = "CourseSaveMapperImpl", componentModel = "spring")
public interface ICourseSaveMapper {
    CourseSave toCourseSave(CourseSaveDTO courseSaveDTO);
}
