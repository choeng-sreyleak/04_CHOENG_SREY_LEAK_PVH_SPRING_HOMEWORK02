package org.spring.demo_springhomework2.service;

import org.spring.demo_springhomework2.model.entity.Course;
import org.spring.demo_springhomework2.model.request.CourseRequest;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses(Integer size, Integer page);

    Course createCourse(CourseRequest request);

    Course getCourseById(Long courseId);

    Course updateCourse(Long courseId, CourseRequest request);

    void deleteCourse(Long courseId);
}
