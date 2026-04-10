package org.berak.app.service.miniedu.enrollment.dto;

import java.util.List;

public class EnrollmentsDTO {
    private List<EnrollmentDTO> enrollments;

    public List<EnrollmentDTO> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<EnrollmentDTO> enrollments) {
        this.enrollments = enrollments;
    }
}
