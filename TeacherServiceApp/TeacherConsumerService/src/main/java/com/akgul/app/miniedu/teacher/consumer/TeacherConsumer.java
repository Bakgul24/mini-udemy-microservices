package com.akgul.app.miniedu.teacher.consumer;

import com.akgul.app.miniedu.teacher.consumer.event.TeacherCreatedEvent;
import com.akgulberat.teacher.data.dal.TeacherPostServiceHelper;
import com.akgulberat.teacher.data.entity.Teacher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TeacherConsumer {
    private final TeacherPostServiceHelper m_teacherPostServiceHelper;
    public TeacherConsumer(TeacherPostServiceHelper teacherPostServiceHelper) {

        m_teacherPostServiceHelper = teacherPostServiceHelper;
    }

    @KafkaListener(topics = "${kafka.topic}", groupId = "teacher-group")
    public Teacher consume(TeacherCreatedEvent event) {
        Teacher teacher = new Teacher();
        teacher.setUserId(event.getUserId());
        teacher.setEmail(event.getEmail());
        teacher.setLastName(event.getLastName());
        teacher.setMiddleName(event.getMiddleName());
        teacher.setFirstName(event.getFirstName());

        return m_teacherPostServiceHelper.save(teacher);
    }
}
