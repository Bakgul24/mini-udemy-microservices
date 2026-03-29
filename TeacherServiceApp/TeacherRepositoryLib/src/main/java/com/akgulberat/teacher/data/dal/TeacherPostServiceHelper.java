package com.akgulberat.teacher.data.dal;

import com.akgulberat.teacher.data.entity.Teacher;
import com.akgulberat.teacher.data.repository.ITeacherRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TeacherPostServiceHelper {
    private final ITeacherRepository m_teacherRepository;

    public TeacherPostServiceHelper(ITeacherRepository teacherRepository) {
        m_teacherRepository = teacherRepository;
    }

    public Teacher save(Teacher teacher) {
        return m_teacherRepository.save(teacher);
    }
}
