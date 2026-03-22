package org.spring.demo_springhomework2.service.impl;

import org.spring.demo_springhomework2.model.entity.Student;
import org.spring.demo_springhomework2.model.request.StudentRequest;
import org.spring.demo_springhomework2.repository.StudentCourseRepository;
import org.spring.demo_springhomework2.repository.StudentRepository;
import org.spring.demo_springhomework2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
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

    @Override
    public Student createStudent(StudentRequest request) {
        Long newId = studentRepository.createStudent(request);
        for (Long courseId : request.getCourseId()) {
            studentCourseRepository.createStudentAndCourse(newId, courseId);
        }
        return studentRepository.getStudentById(newId);
    }




    @Override
    public Student updateStudent(Long studentId, StudentRequest request) {
        studentRepository.updateStudent(studentId, request);
        if (request.getCourseId() != null) {
            studentCourseRepository.removeAllCourses(studentId);
            for (Long courseId : request.getCourseId()) {
                studentCourseRepository.createStudentAndCourse(studentId, courseId);
            }
        }
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentCourseRepository.removeAllCourses(studentId);
        studentRepository.deleteStudent(studentId);
    }

//    @Override
//    public Student updateStudent(Long studentId, StudentRequest request) {
//        studentRepository.updateStudent(studentId, request);
//        return studentRepository.getStudentById(studentId);
//    }

}
