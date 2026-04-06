package org.berakgul.app.service.miniedu.enrollment.service;

import com.berakgul.enrollment.data.dal.EnrollmentPostServiceHelper;
import com.berakgul.enrollment.data.entity.dto.EnrollmentSaveDTO;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private final EnrollmentPostServiceHelper m_enrollmentPostServiceHelper;

    public EnrollmentService(EnrollmentPostServiceHelper enrollmentPostServiceHelper) {
        m_enrollmentPostServiceHelper = enrollmentPostServiceHelper;
    }

    public EnrollmentSaveDTO saveEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
        return m_enrollmentPostServiceHelper.saveEnrollment(enrollmentSaveDTO);
    }

    public void deleteByUserId(int userId) {
        m_enrollmentPostServiceHelper.deleteByUserId(userId);
        System.out.printf("Enrollment silindi User-Id = %d", userId);
    }

    public void deleteByCourseId(int courseId) {
        m_enrollmentPostServiceHelper.deleteByCourseId(courseId);
        System.out.printf("Enrollment silindi Course-Id = %d", courseId);
    }
}
