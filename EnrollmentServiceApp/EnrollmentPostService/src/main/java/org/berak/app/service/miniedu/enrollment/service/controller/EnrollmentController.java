package org.berak.app.service.miniedu.enrollment.service.controller;

import com.berakgul.enrollment.data.entity.dto.EnrollmentSaveDTO;
import org.berak.app.service.miniedu.enrollment.service.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/update/enrollments")
public class EnrollmentController {
    private final EnrollmentService m_enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.m_enrollmentService = enrollmentService;
    }

    @PostMapping("/enrollment/save")
    public ResponseEntity<EnrollmentSaveDTO> save(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO) {
        EnrollmentSaveDTO savedEnrollment = m_enrollmentService.saveEnrollment(enrollmentSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrollment);
    }

    @DeleteMapping("/enrollment/delete/course/{courseId}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable int courseId) {
        try {
            m_enrollmentService.deleteByCourseId(courseId);
            return ResponseEntity.ok("Enrollment başarıyla silindi.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Enrollment silinirken hata oluştu: " + e.getMessage());
        }
    }

    @DeleteMapping("/enrollment/delete/user/{userId}")
    public ResponseEntity<String> deleteByUserId(@PathVariable int userId) {
        try {
            m_enrollmentService.deleteByUserId(userId);
            return ResponseEntity.ok("Enrollment başarıyla silindi.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Enrollment silinirken hata oluştu: " + e.getMessage());
        }
    }
}
