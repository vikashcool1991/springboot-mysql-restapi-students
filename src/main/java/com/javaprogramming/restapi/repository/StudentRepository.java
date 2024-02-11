package com.javaprogramming.restapi.repository;

import com.javaprogramming.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
