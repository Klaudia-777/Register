package com.school.register.service.Implementation;

import com.school.register.model.Class;
import com.school.register.model.SubjectType;
import com.school.register.model.Teacher;
import com.school.register.repository.ClassRepository;
import com.school.register.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    private ClassRepository classRepository;

    @Autowired
    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Class findById(String id) {
        return classRepository.findById(id).get();
    }

    @Override
    public void add(Class aClass) {
        classRepository.save(aClass);
    }

    @Override
    public void delete(Class aClass) {
        classRepository.delete(aClass);
    }

    @Override
    public Set<Class> findBySubject(SubjectType subjectType) {
        return classRepository.getAllClasses()
                .stream()
                .filter(c -> c.getSubjects()
                        .stream()
                        .anyMatch(s -> s.getType()
                                .equals(subjectType)))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Class> findByTutor(Teacher tutor) {
        return classRepository.getAllClasses()
                .stream()
                .filter(c -> c.getTutor()
                        .equals(tutor))
                .collect(Collectors.toSet());
    }
}
