package org.spring.demo_springhomework2.controller;

import org.spring.demo_springhomework2.model.entity.Student;
import org.spring.demo_springhomework2.model.request.StudentRequest;
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
    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentByid (@PathVariable("student-id") Long studentId) {
        Student student = studentService.getStudentByid(studentId);
        ApiResponse<Student> response = ApiResponse.<Student>builder().success(true).status(HttpStatus.OK).message("Student fetched successfully!").payload(student).timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody StudentRequest request) {
        Student student = studentService.createStudent(request);
        ApiResponse<Student> response = ApiResponse.<Student>builder().success(true).status(HttpStatus.CREATED).message("Student created successfully!").payload(student).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(
            @PathVariable("student-id") Long studentId,
            @RequestBody StudentRequest request) {
        Student student = studentService.updateStudent(studentId, request);
        ApiResponse<Student> response = ApiResponse.<Student>builder().success(true).status(HttpStatus.OK).message("Student updated successfully!").payload(student).timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Void>> deleteStudent(@PathVariable("student-id") Long studentId) {
        studentService.deleteStudent(studentId);
        ApiResponse<Void> response = ApiResponse.<Void>builder().success(true).status(HttpStatus.OK).message("Student deleted successfully!").timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



}
