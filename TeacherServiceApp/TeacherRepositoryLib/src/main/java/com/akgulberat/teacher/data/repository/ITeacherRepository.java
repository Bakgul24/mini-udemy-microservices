package com.akgulberat.teacher.data.repository;

import com.akgulberat.teacher.data.entity.Teacher;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Lazy
public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {
    public Optional<Teacher> findByUserId(int userId);
    public Iterable<Teacher> findByExperienceYears(int experienceYears);
    @Modifying
    @Query("update Teacher t set t.totalCourses = :totalCourses where t.id = :id")
    void updateTotalCourses(@Param("id") int id, @Param("totalCourses") int totalCourses);
    @Modifying
    @Query("update Teacher t set t.experienceYears = :experienceYears where t.id = :id")
    void updateExperienceYears(@Param("id") int id, @Param("experienceYears") int experienceYears);
    @Modifying
    @Query("update Teacher t set t.subject = :subject where t.id = :id")
    void updateSubject(@Param("id") int id, @Param("subject") String subject);
}
