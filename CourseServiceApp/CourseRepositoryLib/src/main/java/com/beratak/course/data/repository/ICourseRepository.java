package com.beratak.course.data.repository;

import com.beratak.course.data.entity.Course;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Lazy
public interface ICourseRepository extends CrudRepository<Course, Integer> {
    Iterable<Course> findByActive(boolean active);
    Iterable<Course> findAllByTeacherIdAndActive(int teacherId, boolean active);
    @Query("SELECT DISTINCT c.teacherId FROM Course c")
    List<Integer> findDistinctTeacherIds();
    void deleteByTeacherId(Integer teacherId);
}
