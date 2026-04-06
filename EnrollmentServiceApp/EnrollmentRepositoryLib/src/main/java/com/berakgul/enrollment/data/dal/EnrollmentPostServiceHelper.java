package com.berakgul.enrollment.data.dal;

import com.berakgul.enrollment.data.repository.IEnrollmentRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class EnrollmentPostServiceHelper {
    private final IEnrollmentRepository m_enrollmentRepository;

    public EnrollmentPostServiceHelper(IEnrollmentRepository enrollmentRepository) {
        m_enrollmentRepository = enrollmentRepository;
    }

    public void deleteByUserId(int userId) {
        m_enrollmentRepository.deleteByUserId(userId);
    }

    public void deleteByCourseId(int courseId){
        m_enrollmentRepository.deleteByCourseId(courseId);
    }
}
