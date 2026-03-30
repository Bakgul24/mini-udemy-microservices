package org.akgul.app.service.miniedu.teacher.controller;

import org.akgul.app.service.miniedu.teacher.dto.DeleteTeacherDTO;
import org.akgul.app.service.miniedu.teacher.dto.UpdateTeacherExperienceYearsDTO;
import org.akgul.app.service.miniedu.teacher.dto.UpdateTeacherSubjectDTO;
import org.akgul.app.service.miniedu.teacher.dto.UpdateTeacherTotalCoursesDTO;
import org.akgul.app.service.miniedu.teacher.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/update/teachers")
public class TeacherController {

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PutMapping("/update/experience-years")
    public ResponseEntity<String> updateExperienceYears(@RequestBody UpdateTeacherExperienceYearsDTO dto) {
        logger.info("Updating experience years for teacher id: {}", dto.getId());
        teacherService.updateTeacherExperienceYears(dto);
        return ResponseEntity.ok("Teacher experience years updated successfully");
    }

    @PutMapping("/update/subject")
    public ResponseEntity<String> updateSubject(@RequestBody UpdateTeacherSubjectDTO dto) {
        logger.info("Updating subject for teacher id: {}", dto.getId());
        teacherService.updateTeacherSubject(dto);
        return ResponseEntity.ok("Teacher subject updated successfully");
    }

    @PutMapping("/update/total-courses")
    public ResponseEntity<String> updateTotalCourses(@RequestBody UpdateTeacherTotalCoursesDTO dto) {
        logger.info("Updating total courses for teacher id: {}", dto.getId());
        teacherService.updateTeacherTotalCourses(dto);
        return ResponseEntity.ok("Teacher total courses updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteTeacher(@RequestBody DeleteTeacherDTO dto) {
        logger.info("Deleting teacher with id: {}", dto.getId());
        teacherService.deleteTeacherById(dto);
        return ResponseEntity.ok("Teacher deleted successfully");
    }
}