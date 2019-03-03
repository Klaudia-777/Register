package com.school.register.dao;

import com.school.register.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,String> {
}
