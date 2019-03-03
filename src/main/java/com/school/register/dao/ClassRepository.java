package com.school.register.dao;

import com.school.register.model.Class;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<Class,String> {
}
