package org.akgul.app.service.miniedu.teacher.controller;

import org.akgul.app.service.miniedu.teacher.dto.TeachersDTO;
import org.akgul.app.service.miniedu.teacher.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/read/teachers")
public class TeacherController {
    private final TeacherService m_teacherService;

    public TeacherController(TeacherService teacherService) {
        m_teacherService = teacherService;
    }

    @GetMapping("/find/experienceYears")
    public TeachersDTO findTeacherByExperienceYears(@RequestParam("ex") int experienceYears) {
        return m_teacherService.findTeacherByExperienceYears(experienceYears);
    }
}
