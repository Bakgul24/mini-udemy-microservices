package org.berak.app.service.miniedu.enrollment.controller;

import org.berak.app.service.miniedu.enrollment.dto.EnrollmentsDTO;
import org.berak.app.service.miniedu.enrollment.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/find/enrollments")
public class EnrollmentController {
    private final EnrollmentService m_enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        m_enrollmentService = enrollmentService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<EnrollmentsDTO> findByUserId(@PathVariable int userId) {
        var enrollments = m_enrollmentService.findByUserId(userId);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<EnrollmentsDTO> findByCourseId(@PathVariable int courseId) {
        var enrollments = m_enrollmentService.findByCourseId(courseId);
        return ResponseEntity.ok(enrollments);
    }
}
