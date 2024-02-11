package com.javaprogramming.restapi.controller;

import com.javaprogramming.restapi.entity.Student;
import com.javaprogramming.restapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    StudentRepository repo;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        List<Student> students = repo.findAll();
        return students;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        return student;
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = repo.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student currentStudent = repo.findById(id).get();
        currentStudent.setName(student.getName());
        currentStudent.setBranch(student.getBranch());
        currentStudent.setPercentage(student.getPercentage());
        repo.save(currentStudent);
        return currentStudent;
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeStudent(@PathVariable int id) {
        Student student = repo.findById(id).get();
        repo.delete(student);
    }
}
