package org.akgul.app.service.miniedu.teacher.service;

import com.akgulberat.teacher.data.dal.TeacherGetServiceHelper;
import org.akgul.app.service.miniedu.teacher.dto.TeachersDTO;
import org.akgul.app.service.miniedu.teacher.mapper.ITeacherMapper;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {
    private final TeacherGetServiceHelper m_getServiceHelper;
    private final ITeacherMapper m_teacherMapper;

    public TeacherService(TeacherGetServiceHelper teacherGetServiceHelper, ITeacherMapper teacherMapper) {
        m_getServiceHelper = teacherGetServiceHelper;
        m_teacherMapper = teacherMapper;
    }

    public TeachersDTO findTeacherByExperienceYears(int experienceYears) {
        var teacherIterable = m_getServiceHelper.findByExperienceYears(experienceYears);

        var teacherList = StreamSupport.stream(teacherIterable.spliterator(), false)
                .map(m_teacherMapper::toTeacherDTO)
                .collect(Collectors.toList());

        return m_teacherMapper.toUsersDto(teacherList);
    }
}
