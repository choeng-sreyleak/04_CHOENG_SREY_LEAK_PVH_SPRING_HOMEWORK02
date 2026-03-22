package org.spring.demo_springhomework2.controller;

import org.spring.demo_springhomework2.model.entity.Course;
import org.spring.demo_springhomework2.model.request.CourseRequest;
import org.spring.demo_springhomework2.model.response.ApiResponse;
import org.spring.demo_springhomework2.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses( @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Course> courses = courseService.getAllCourses(size, page);
        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder().success(true).status(HttpStatus.OK).message("Courses fetched successfully!").payload(courses).timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody CourseRequest request) {
        Course course = courseService.createCourse(request);
        ApiResponse<Course> response = ApiResponse.<Course>builder().success(true).status(HttpStatus.CREATED).message("Course created successfully!").payload(course).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id") Long courseId){
        Course course = courseService.getCourseById(courseId);
        ApiResponse<Course> response = ApiResponse.<Course>builder().success(true).status(HttpStatus.OK).message("Course fetched successfully!").payload(course).timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long courseId, @RequestBody CourseRequest request) {

        Course course = courseService.updateCourse(courseId, request);
        ApiResponse<Course> response = ApiResponse.<Course>builder().success(true).status(HttpStatus.OK).message("Course updated successfully!").payload(course).timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Void>> deleteCourse(@PathVariable("course-id") Long courseId) {
        courseService.deleteCourse(courseId);
        ApiResponse<Void> response = ApiResponse.<Void>builder().success(true).status(HttpStatus.OK).message("Course deleted successfully!").timestamp(Instant.now()).build();
        return ResponseEntity.ok(response);
    }
}
