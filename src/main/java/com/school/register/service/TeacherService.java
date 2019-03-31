package com.school.register.service;

import com.school.register.model.Class;
import com.school.register.model.SubjectType;
import com.school.register.model.Teacher;

import java.util.Set;

public interface TeacherService {
    Teacher findById(String id);
    Set<Teacher> findByClass(Class aClass);
    Set<Teacher> findBySubjectType(SubjectType subjectType);
    void add(Teacher teacher);
    void delete(Teacher teacher);

}
