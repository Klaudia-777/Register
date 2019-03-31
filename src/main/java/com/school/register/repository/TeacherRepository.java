package com.school.register.repository;

import com.school.register.model.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface TeacherRepository extends CrudRepository<Teacher,String> {
    @Query("Select distinct t from Teacher  t")
    Set<Teacher> getAllTeachers();
}
