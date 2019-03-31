package com.school.register.service;

import com.school.register.model.Class;
import com.school.register.model.Subject;
import com.school.register.model.SubjectType;
import com.school.register.model.Teacher;

import java.util.Set;

public interface ClassService {
    Class findById(String id);
    void add(Class aClass);
    void delete(Class aClass);
    Set<Class> findBySubject(SubjectType subjectType);
    Set<Class> findByTutor(Teacher tutor);
}
