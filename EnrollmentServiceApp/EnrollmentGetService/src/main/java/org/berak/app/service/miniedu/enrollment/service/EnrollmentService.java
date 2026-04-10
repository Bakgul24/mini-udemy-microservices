package org.berak.app.service.miniedu.enrollment.service;

import com.berakgul.enrollment.data.dal.EnrollmentGetServiceHelper;
import com.berakgul.enrollment.data.entity.Enrollment;
import org.berak.app.service.miniedu.enrollment.dto.EnrollmentsDTO;
import org.berak.app.service.miniedu.enrollment.mapper.IEnrollmentMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EnrollmentService {
    private final EnrollmentGetServiceHelper m_enrollmentGetServiceHelper;
    private final IEnrollmentMapper m_enrollmentMapper;
    public EnrollmentService(EnrollmentGetServiceHelper enrollmentGetServiceHelper, IEnrollmentMapper enrollmentMapper) {
        m_enrollmentGetServiceHelper = enrollmentGetServiceHelper;
        m_enrollmentMapper = enrollmentMapper;
    }

    public EnrollmentsDTO findByUserId(int userId) {
        Iterable<Enrollment> enrollmentsIterable = m_enrollmentGetServiceHelper.findByUserId(userId);

        var enrollmentsDtoList = StreamSupport.stream(enrollmentsIterable.spliterator(), false)
                .map(m_enrollmentMapper::toEnrollmentDTO)
                .collect(Collectors.toList());

        return m_enrollmentMapper.toEnrollmentsDTO(enrollmentsDtoList);
    }

    public EnrollmentsDTO findByCourseId(int courseId) {
        Iterable<Enrollment> enrollmentsIterable = m_enrollmentGetServiceHelper.findByCourseId(courseId);

        var enrollmentsDtoList = StreamSupport.stream(enrollmentsIterable.spliterator(), false)
                .map(m_enrollmentMapper::toEnrollmentDTO)
                .collect(Collectors.toList());

        return m_enrollmentMapper.toEnrollmentsDTO(enrollmentsDtoList);
    }
}
