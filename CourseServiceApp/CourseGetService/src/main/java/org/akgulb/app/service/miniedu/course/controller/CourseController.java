package org.akgulb.app.service.miniedu.course.controller;

import org.akgulb.app.service.miniedu.course.dto.CourseDTO;
import org.akgulb.app.service.miniedu.course.dto.CoursesDTO;
import org.akgulb.app.service.miniedu.course.service.CourseGetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/read/courses")
public class CourseController {
    private final CourseGetService m_courseGetService;

    public CourseController(CourseGetService courseGetService) {
        m_courseGetService = courseGetService;
    }

    @GetMapping("/find/id")
    public ResponseEntity<CourseDTO> findById(@RequestParam("id") int id) {
        return m_courseGetService.findByCourseId(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() ->
                        new com.miniedu.exception.common.ResourceNotFoundException("Course", "id: " + id)
                );
    }

    @GetMapping("/teachers/{teacherId}/courses/active/{active}")
    public ResponseEntity<CoursesDTO> getCoursesByTeacherAndActive(
            @PathVariable int teacherId,
            @PathVariable boolean active) {

        CoursesDTO courses = m_courseGetService.findAllCoursesByTeacherIdAndActive(teacherId, active);

        if (courses == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(courses);
    }

    @GetMapping("/active")
    public ResponseEntity<CoursesDTO> getCoursesByActive(
            @RequestParam(defaultValue = "true") boolean active) {

        CoursesDTO courses = m_courseGetService.findAllCoursesByActive(active);

        if (null == courses)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(courses);
    }
}
