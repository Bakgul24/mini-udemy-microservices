package com.akgulberat.teacher.data.dal;

import com.akgulberat.teacher.data.repository.ITeacherRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@Lazy
public class TeacherCommandServiceHelper {
    private final ITeacherRepository m_teacherRepository;

    public TeacherCommandServiceHelper(ITeacherRepository teacherRepository) {
        m_teacherRepository = teacherRepository;
    }

    public void updateTotalCourses(int id, int totalCourses) {
        m_teacherRepository.updateTotalCourses(id, totalCourses);
    }

    public void updateSubject(int id, String subject) {
        m_teacherRepository.updateSubject(id, subject);
    }

    public void updateExperienceYears(int id, int experienceYears) {
        m_teacherRepository.updateExperienceYears(id, experienceYears);
        System.out.print(experienceYears);
    }

    public void deleteTeacherById(int id) {
        m_teacherRepository.deleteById(id);
    }
}
