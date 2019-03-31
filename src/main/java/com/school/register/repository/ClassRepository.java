package com.school.register.repository;

import com.school.register.model.Class;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ClassRepository extends CrudRepository<Class,String> {
    @Query("select distinct c from class c ")
    Set<Class> getAllClasses();
}
