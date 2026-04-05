package com.beratak.course.data.dal;

import com.beratak.course.data.entity.dto.CourseSave;
import com.beratak.course.data.mapper.ICourseMapper;
import com.beratak.course.data.repository.ICourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CoursePostServiceHelper {
    private final ICourseRepository m_courseRepository;
    private final ICourseMapper m_courseMapper;

    public CoursePostServiceHelper(ICourseRepository courseRepository, ICourseMapper courseMapper) {
        m_courseRepository = courseRepository;
        m_courseMapper = courseMapper;
    }

    @Transactional
    public CourseSave saveCourse(CourseSave courseDto) {
        m_courseRepository.save(m_courseMapper.toCourse(courseDto));
        return courseDto;
    }
}
