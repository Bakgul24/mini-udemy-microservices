package org.akgulb.app.service.miniedu.course.service;

import org.akgulb.app.service.miniedu.course.dto.CourseSaveDTO;
import org.akgulb.app.service.miniedu.course.mapper.ICourseSaveMapper;
import com.beratak.course.data.dal.CoursePostServiceHelper;
import org.springframework.stereotype.Service;

@Service
public class CoursePostService {
    private final CoursePostServiceHelper m_coursePostServiceHelper;
    public final ICourseSaveMapper m_courseSaveMapper;
    public CoursePostService(CoursePostServiceHelper coursePostServiceHelper, ICourseSaveMapper courseSaveMapper) {
        m_coursePostServiceHelper = coursePostServiceHelper;
        m_courseSaveMapper = courseSaveMapper;
    }

    public CourseSaveDTO saveCourse(CourseSaveDTO courseSaveDTO) {
        m_coursePostServiceHelper.saveCourse(m_courseSaveMapper.toCourseSave(courseSaveDTO));

        return courseSaveDTO;
    }
}
