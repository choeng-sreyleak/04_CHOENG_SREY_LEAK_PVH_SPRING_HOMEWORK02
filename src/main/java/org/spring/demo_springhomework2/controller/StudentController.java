package org.spring.demo_springhomework2.controller;

import org.spring.demo_springhomework2.model.entity.Student;
import org.spring.demo_springhomework2.model.response.ApiResponse;
import org.spring.demo_springhomework2.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        List<Student> students = studentService.getAllStudents(size, page);
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder().success(true).status(HttpStatus.OK).message("Student Fetch Successfully!!").payload(students).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    @GetMapping("/{student_id}")
    public Student getStudentsById(@PathVariable("student_id") long studentId){
        return studentService.getStudentByid(studentId);
    }
}
