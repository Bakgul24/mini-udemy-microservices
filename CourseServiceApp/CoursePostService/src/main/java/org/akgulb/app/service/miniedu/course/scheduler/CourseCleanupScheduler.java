package org.akgulb.app.service.miniedu.course.scheduler;

import com.beratak.course.data.dal.CourseGetServiceHelper;
import com.beratak.course.data.dal.CoursePostServiceHelper;
import org.akgulb.app.service.miniedu.course.client.TeacherClient;
import org.akgulb.app.service.miniedu.course.dto.TeacherExistsDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CourseCleanupScheduler {
    private final CourseGetServiceHelper m_courseGetServiceHelper;
    private final CoursePostServiceHelper m_coursePostServiceHelper;
    private final TeacherClient teacherClient;

    public CourseCleanupScheduler(CourseGetServiceHelper courseGetServiceHelper,
                                  CoursePostServiceHelper coursePostServiceHelper,
                                  TeacherClient teacherClient) {
        this.m_courseGetServiceHelper = courseGetServiceHelper;
        this.m_coursePostServiceHelper = coursePostServiceHelper;
        this.teacherClient = teacherClient;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void deleteCoursesOfDeletedTeachers() {
        var teacherIds = m_courseGetServiceHelper.findDistinctTeacherIds();
        for (var teacherId : teacherIds) {
            try {
                TeacherExistsDTO teacherExistsDTO = teacherClient.existsById(teacherId);
                if (!teacherExistsDTO.isExists()) {
                    m_coursePostServiceHelper.deleteByTeacherId(teacherId);
                }
            } catch (Exception e) {
                System.out.print("Teacher Servisine Ulaşılamadı!");
            }
        }
    }
}