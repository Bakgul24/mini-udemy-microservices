package com.akgulberat.teacher.data.repository;

import com.akgulberat.teacher.data.entity.Teacher;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Lazy
public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {
    public Optional<Teacher> findByUserId(int userId);
}
