package com.school.register.controller;

import com.school.register.model.Class;
import com.school.register.model.SubjectType;
import com.school.register.service.ClassService;
import com.school.register.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ClassController {
    private ClassService classService;
    private TeacherService teacherService;

    @Autowired
    public ClassController(ClassService classService, TeacherService teacherService) {
        this.classService = classService;
        this.teacherService = teacherService;
    }

    @GetMapping("/classes/{id}")
    Class getById(@PathVariable String id) {
        return classService.findById(id);
    }

    @GetMapping("/classes/{tutorId}")
    Set<Class> getByTutor(@PathVariable String tutorId) {
        return classService.findByTutor(teacherService.findById(tutorId));
    }

    @GetMapping("/classes/{subjectType}")
    Set<Class> getBySubjectType(@PathVariable String subjectType) {
        return classService.findBySubject(SubjectType.valueOf(subjectType));
    }
}