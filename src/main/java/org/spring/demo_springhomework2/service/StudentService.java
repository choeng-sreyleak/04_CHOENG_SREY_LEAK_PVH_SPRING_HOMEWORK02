package org.spring.demo_springhomework2.service;

import org.spring.demo_springhomework2.model.entity.Student;

import java.util.List;

public interface StudentService {
       List<Student> getAllStudents(Integer size, Integer page);


       Student getStudentByid(long studentId);
}
