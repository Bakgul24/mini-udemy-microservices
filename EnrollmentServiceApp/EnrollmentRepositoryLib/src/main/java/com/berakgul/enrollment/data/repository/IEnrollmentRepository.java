package com.berakgul.enrollment.data.repository;

import com.berakgul.enrollment.data.entity.Enrollment;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Lazy
@Repository
public interface IEnrollmentRepository extends CrudRepository<Enrollment, Integer> {
    void deleteByUserId(int userId);
    void deleteByCourseId(int userId);
    Iterable<Enrollment> findByCourseId(int courseId);
    Iterable<Enrollment> findByUserId(int userId);
}
