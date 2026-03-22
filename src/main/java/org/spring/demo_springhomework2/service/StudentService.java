package org.spring.demo_springhomework2.service;

import org.spring.demo_springhomework2.model.entity.Student;
import org.spring.demo_springhomework2.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
       List<Student> getAllStudents(Integer size, Integer page);

       Student getStudentByid(long studentId);

       Student createStudent(StudentRequest request);

       Student updateStudent(Long studentId, StudentRequest request);

       void deleteStudent(Long studentId);

}
