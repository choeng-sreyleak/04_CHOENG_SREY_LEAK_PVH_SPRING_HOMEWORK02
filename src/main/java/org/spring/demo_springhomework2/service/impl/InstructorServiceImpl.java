package org.spring.demo_springhomework2.service.impl;

import lombok.RequiredArgsConstructor;
import org.spring.demo_springhomework2.model.entity.Instructor;
import org.spring.demo_springhomework2.model.request.InstructorRequest;
import org.spring.demo_springhomework2.repository.InstructorRepository;
import org.spring.demo_springhomework2.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
   private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> getAllInstructors(Integer size, Integer page) {
        Integer offset = size * (page - 1);
        return instructorRepository.getAllInstructors(offset ,size);
    }
    @Override
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public Instructor createInstructor(InstructorRequest request) {
        return instructorRepository.createInstructor(request);
    }

    @Override
    public Instructor updateInstructorById(Long instructorId, InstructorRequest request) {
        return instructorRepository.updateInstructorById(instructorId, request);
    }
    @Override
    public void deleteInstructorById(Long instructorId) {
        instructorRepository.deleteInstructorById(instructorId);
    }

}
