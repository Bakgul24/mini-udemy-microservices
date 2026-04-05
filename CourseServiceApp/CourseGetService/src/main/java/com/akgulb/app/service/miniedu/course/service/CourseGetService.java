package com.akgulb.app.service.miniedu.course.service;

import com.akgulb.app.service.miniedu.course.dto.CourseDTO;
import com.akgulb.app.service.miniedu.course.dto.CoursesDTO;
import com.akgulb.app.service.miniedu.course.mapper.ICourseMapper;
import com.beratak.course.data.dal.CourseGetServiceHelper;
import com.beratak.course.data.entity.Course;
import com.miniedu.exception.common.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseGetService {
    private final CourseGetServiceHelper m_courseGetServiceHelper;
    private final ICourseMapper m_courseMapper;

    public CourseGetService(CourseGetServiceHelper courseGetServiceHelper, ICourseMapper courseMapper) {
        m_courseGetServiceHelper = courseGetServiceHelper;
        m_courseMapper = courseMapper;
    }

    public Optional<CourseDTO> findByCourseId(int id) {
        return m_courseGetServiceHelper.findByCourseId(id).map(m_courseMapper::toCourseDTO).or(() -> {
            throw ResourceNotFoundException.byId("Course", id);
        });
    }

    public CoursesDTO findAllCoursesByTeacherIdAndActive(int teacherId, boolean active) {
        Iterable<Course> coursesIterable = m_courseGetServiceHelper.findAllCoursesByTeacherIdAndActive(teacherId, active);

        var coursesDtoList = StreamSupport.stream(coursesIterable.spliterator(), false)
                .map(m_courseMapper::toCourseDTO)
                .collect(Collectors.toList());

        return m_courseMapper.toCoursesDTO(coursesDtoList);
    }

    public CoursesDTO findAllCoursesByActive(boolean active) {
        Iterable<Course> coursesIterable = m_courseGetServiceHelper.findAllCoursesByActive(active);

        var coursesDtoList = StreamSupport.stream(coursesIterable.spliterator(), false)
                .map(m_courseMapper::toCourseDTO)
                .collect(Collectors.toList());

        return m_courseMapper.toCoursesDTO(coursesDtoList);
    }
}
