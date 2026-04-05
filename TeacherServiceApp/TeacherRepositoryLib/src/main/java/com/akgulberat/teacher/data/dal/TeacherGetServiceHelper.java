package com.akgulberat.teacher.data.dal;

import com.akgulberat.teacher.data.entity.Teacher;
import com.akgulberat.teacher.data.repository.ITeacherRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class TeacherGetServiceHelper {
    private final ITeacherRepository m_teacherRepository;
    public TeacherGetServiceHelper(ITeacherRepository teacherRepository) {
        m_teacherRepository = teacherRepository;
    }

    public Optional<Teacher> findTeacherByUserId(int userId) {
        return m_teacherRepository.findByUserId(userId);
    }

    public Optional<Teacher> findById(int id) {
        return m_teacherRepository.findById(id);
    }

    public Iterable<Teacher> findByExperienceYears(int experienceYears) {
        return m_teacherRepository.findByExperienceYears(experienceYears);
    }

    public boolean existsByTeacherId(int id) {
        return m_teacherRepository.existsById(id);
    }
}
