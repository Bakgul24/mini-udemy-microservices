package com.berakgul.enrollment.data.dal;

import com.berakgul.enrollment.data.entity.Enrollment;
import com.berakgul.enrollment.data.repository.IEnrollmentRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class EnrollmentGetServiceHelper {
    private final IEnrollmentRepository m_enrollmentRepository;

    public EnrollmentGetServiceHelper(IEnrollmentRepository enrollmentRepository) {
        m_enrollmentRepository = enrollmentRepository;
    }

    public Iterable<Enrollment> findByCourseId(int courseId) {
        return m_enrollmentRepository.findByCourseId(courseId);
    }

    public Iterable<Enrollment> findByUserId(int userId) {
        return m_enrollmentRepository.findByUserId(userId);
    }
}
