package com.school.register.controller;

import com.school.register.model.SubjectType;
import com.school.register.model.Teacher;
import com.school.register.service.ClassService;
import com.school.register.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TeacherController {
    private final TeacherService teacherService;
    private  final ClassService classService;

    @Autowired
    public TeacherController(TeacherService teacherService, ClassService classService) {
        this.teacherService = teacherService;
        this.classService = classService;
    }

    @GetMapping("/teachers/{id}")
    Teacher getById(@PathVariable String id){
        return teacherService.findById(id);
    }

    @GetMapping("/teachers/{subjectType}")
    Set<Teacher> getBySubjectType(@PathVariable String subjectType){
        return teacherService.findBySubjectType(SubjectType.valueOf(subjectType));
    }
    @GetMapping("/teachers/{classId}")
    Set<Teacher> getByClasses(@PathVariable String classId){
        return teacherService.findByClass(classService.findById(classId));
    }
}
