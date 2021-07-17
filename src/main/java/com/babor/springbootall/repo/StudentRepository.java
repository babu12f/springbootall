package com.babor.springbootall.repo;

import com.babor.springbootall.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
