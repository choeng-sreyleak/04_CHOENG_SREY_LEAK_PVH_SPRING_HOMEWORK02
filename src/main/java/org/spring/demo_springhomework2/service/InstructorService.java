package org.spring.demo_springhomework2.service;

import org.spring.demo_springhomework2.model.entity.Instructor;
import org.spring.demo_springhomework2.model.entity.Student;
import org.spring.demo_springhomework2.model.request.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Integer size, Integer page);

    Instructor getInstructorById(Long instructorId);

    Instructor createInstructor(InstructorRequest request);

    Instructor updateInstructorById(Long instructorId, InstructorRequest request);

    void deleteInstructorById(Long instructorId);

}
