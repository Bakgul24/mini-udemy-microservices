package com.beratak.course.data.dal;

import com.beratak.course.data.entity.Course;
import com.beratak.course.data.repository.ICourseRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Lazy
public class CourseGetServiceHelper {
    private final ICourseRepository m_courseRepository;

    public CourseGetServiceHelper(ICourseRepository courseRepository) {
        m_courseRepository = courseRepository;
    }

    public Iterable<Course> findAllCoursesByActive(boolean active) {
        return m_courseRepository.findByActive(active);
    }

    public Optional<Course> findByCourseId(int courseId) {
        return m_courseRepository.findById(courseId);
    }

    public Iterable<Course> findAllCoursesByTeacherIdAndActive(int teacherId, boolean active) {
        return m_courseRepository.findAllByTeacherIdAndActive(teacherId, active);
    }

    public List<Integer> findDistinctTeacherIds() {
        return m_courseRepository.findDistinctTeacherIds();
    }
}
