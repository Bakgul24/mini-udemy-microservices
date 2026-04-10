package com.berakgul.enrollment.data.dal;

import com.berakgul.enrollment.data.entity.Enrollment;
import com.berakgul.enrollment.data.entity.dto.EnrollmentSaveDTO;
import com.berakgul.enrollment.data.repository.IEnrollmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class EnrollmentPostServiceHelper {
    private final IEnrollmentRepository m_enrollmentRepository;

    public EnrollmentPostServiceHelper(IEnrollmentRepository enrollmentRepository) {
        m_enrollmentRepository = enrollmentRepository;
    }
    @Transactional
    public void deleteByUserId(int userId) {
        m_enrollmentRepository.deleteByUserId(userId);
    }

    @Transactional
    public void deleteByCourseId(int courseId){
        System.out.print("--------------------"+courseId);
        m_enrollmentRepository.deleteByCourseId(courseId);
    }

    @Transactional
    public EnrollmentSaveDTO saveEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
        Enrollment enrollmentEntity = m_enrollmentRepository.findById(enrollmentSaveDTO.getId())
                .orElse(new Enrollment());

        updateEnrollmentFromDto(enrollmentSaveDTO, enrollmentEntity);
        m_enrollmentRepository.save(enrollmentEntity);

        enrollmentSaveDTO.setId(enrollmentEntity.getId());
        return enrollmentSaveDTO;
    }

    private void updateEnrollmentFromDto(EnrollmentSaveDTO enrollmentSaveDTO, Enrollment enrollmentEntity) {
        enrollmentEntity.setUserId(enrollmentSaveDTO.getUserId());
        enrollmentEntity.setCourseId(enrollmentSaveDTO.getCourseId());
        enrollmentEntity.setEnrollDate(enrollmentSaveDTO.getEnrollDate());
    }
}
