package org.akgulb.app.service.miniedu.course.controller;

import org.akgulb.app.service.miniedu.course.dto.CourseSaveDTO;
import org.akgulb.app.service.miniedu.course.service.CoursePostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/update/courses")
public class CourseController {
    private final CoursePostService m_coursePostService;

    public CourseController(CoursePostService coursePostService) {
        m_coursePostService = coursePostService;
    }

    @PostMapping("/course/save")
    public ResponseEntity<CourseSaveDTO> saveCourse(@RequestBody CourseSaveDTO courseSaveDto) {
        var savedCourse = m_coursePostService.saveCourse(courseSaveDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }
}
