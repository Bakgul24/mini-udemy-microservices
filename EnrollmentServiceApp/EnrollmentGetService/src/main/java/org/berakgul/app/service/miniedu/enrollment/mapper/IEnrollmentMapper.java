package org.berakgul.app.service.miniedu.enrollment.mapper;

import com.berakgul.enrollment.data.entity.Enrollment;
import org.berakgul.app.service.miniedu.enrollment.dto.EnrollmentDTO;
import org.berakgul.app.service.miniedu.enrollment.dto.EnrollmentsDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "EnrollmentMapperImpl", componentModel = "spring")
public interface IEnrollmentMapper {
    EnrollmentDTO toEnrollmentDTO(Enrollment enrollment);

    default EnrollmentsDTO toEnrollmentsDTO(List<EnrollmentDTO> enrollmentDTOList) {
        var dto = new EnrollmentsDTO();

        dto.setEnrollments(enrollmentDTOList);

        return dto;
    }
}
