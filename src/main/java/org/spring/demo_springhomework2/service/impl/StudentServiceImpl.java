package org.spring.demo_springhomework2.service.impl;

import org.spring.demo_springhomework2.model.entity.Student;
import org.spring.demo_springhomework2.repository.StudentRepository;
import org.spring.demo_springhomework2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents (Integer size , Integer page) {
        Integer offset = size * (page - 1);
        return studentRepository.getAllStudents(offset ,size);
    }

    @Override
    public Student getStudentByid(long studentId) {
        return studentRepository.getStudentById(studentId);
    }
}
