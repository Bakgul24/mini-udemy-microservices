package org.akgul.app.service.miniedu.teacher.controller;

import org.akgul.app.service.miniedu.teacher.dto.TeacherExistsDTO;
import org.akgul.app.service.miniedu.teacher.dto.TeachersDTO;
import org.akgul.app.service.miniedu.teacher.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/read/teachers")
public class TeacherController {
    private final TeacherService m_teacherService;

    public TeacherController(TeacherService teacherService) {
        m_teacherService = teacherService;
    }

    @GetMapping("/find/experienceYears")
    public TeachersDTO findTeacherByExperienceYears(@RequestParam("ex") int experienceYears) {
        return m_teacherService.findTeacherByExperienceYears(experienceYears);
    }

    @GetMapping("/{id}/exists")
    public TeacherExistsDTO exists(@PathVariable int id) {
        return m_teacherService.existsByTeacherId(id);
    }
}
