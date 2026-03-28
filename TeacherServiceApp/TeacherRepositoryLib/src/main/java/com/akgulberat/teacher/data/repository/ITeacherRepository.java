package com.akgulberat.teacher.data.repository;

import com.akgulberat.teacher.data.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {
}
