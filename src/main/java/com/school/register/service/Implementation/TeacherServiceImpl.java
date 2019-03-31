package com.school.register.service.Implementation;

import com.school.register.model.Class;
import com.school.register.repository.TeacherRepository;
import com.school.register.model.SubjectType;
import com.school.register.model.Teacher;
import com.school.register.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher findById(String id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Set<Teacher> findByClass(Class aClass) {
        return teacherRepository.getAllTeachers()
                .stream()
                .filter(n->n.getSubjects()
                        .stream()
                        .anyMatch(s->s.getAClass()
                                .equals(aClass)))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Teacher> findBySubjectType(SubjectType subjectType) {
        return teacherRepository.getAllTeachers()
                .stream()
                .filter(n -> n.getSubjects()
                        .stream()
                        .anyMatch(s -> s.getType()
                                .equals(subjectType)))
                .collect(Collectors.toSet());
    }

    @Override
    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }
}
