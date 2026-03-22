package org.spring.demo_springhomework2.service.impl;

import org.spring.demo_springhomework2.model.entity.Course;
import org.spring.demo_springhomework2.model.request.CourseRequest;
import org.spring.demo_springhomework2.repository.CourseRepository;
import org.spring.demo_springhomework2.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Integer size, Integer page) {
        Integer offset = size * (page - 1);
        return courseRepository.getAllCourses(offset, size);
    }

    @Override
    public Course createCourse(CourseRequest request) {
        Long newId = courseRepository.createCourse(request);
        return courseRepository.getCourseById(newId);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course updateCourse(Long courseId, CourseRequest request) {
        courseRepository.updateCourse(courseId, request);
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteCourse(courseId);
    }
}
