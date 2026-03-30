package org.akgul.app.service.miniedu.teacher.service;

import com.akgulberat.teacher.data.dal.TeacherCommandServiceHelper;
import jakarta.transaction.Transactional;
import org.akgul.app.service.miniedu.teacher.dto.DeleteTeacherDTO;
import org.akgul.app.service.miniedu.teacher.dto.UpdateTeacherExperienceYearsDTO;
import org.akgul.app.service.miniedu.teacher.dto.UpdateTeacherSubjectDTO;
import org.akgul.app.service.miniedu.teacher.dto.UpdateTeacherTotalCoursesDTO;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherCommandServiceHelper m_teacherCommandServiceHelper;

    public TeacherService(TeacherCommandServiceHelper teacherCommandServiceHelper) {
        m_teacherCommandServiceHelper = teacherCommandServiceHelper;
    }
    @Transactional
    public void updateTeacherExperienceYears(UpdateTeacherExperienceYearsDTO updateTeacher) {
        System.out.print(updateTeacher.getId());
        System.out.print("experinceyear" + updateTeacher.getExperienceYears());
        m_teacherCommandServiceHelper.updateExperienceYears(updateTeacher.getId(), updateTeacher.getExperienceYears());
    }
    @Transactional
    public void updateTeacherSubject(UpdateTeacherSubjectDTO updateTeacher) {
        m_teacherCommandServiceHelper.updateSubject(updateTeacher.getId(), updateTeacher.getSubject());
    }

    @Transactional
    public void updateTeacherTotalCourses(UpdateTeacherTotalCoursesDTO updateTeacher) {
        m_teacherCommandServiceHelper.updateTotalCourses(updateTeacher.getId(), updateTeacher.getTotalCourses());
    }
    @Transactional
    public void deleteTeacherById(DeleteTeacherDTO deleteTeacher) {
        m_teacherCommandServiceHelper.deleteTeacherById(deleteTeacher.getId());
    }
}
