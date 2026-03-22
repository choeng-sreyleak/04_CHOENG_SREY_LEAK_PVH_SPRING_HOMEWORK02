package org.spring.demo_springhomework2.repository;

import org.apache.ibatis.annotations.*;
import org.spring.demo_springhomework2.model.entity.Course;
import org.spring.demo_springhomework2.model.request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id", id = true),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.spring.demo_springhomework2.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
        SELECT *from courses OFFSET #{offset} LIMIT #{size}
    """)
    List<Course> getAllCourses(@Param("offset") int offset, @Param("size") int size);

    @Select("""
        SELECT *from courses WHERE course_id = #{courseId}
    """)
    @ResultMap("courseMapper")
    Course getCourseById(Long courseId);

    @Insert("""
        INSERT INTO courses (course_name, description, instructor_id)
        VALUES (#{req.courseName}, #{req.description}, #{req.instructorId})
        RETURNING course_id
    """)
    Long createCourse(@Param("req") CourseRequest request);

    @Update("""
        UPDATE courses
        SET course_name = #{req.courseName},
            description = #{req.description},
            instructor_id = #{req.instructorId}
        WHERE course_id = #{courseId}
    """)
    void updateCourse(@Param("courseId") Long courseId, @Param("req") CourseRequest request);

    @Delete("DELETE FROM courses WHERE course_id = #{courseId}")
    void deleteCourse(Long courseId);


}
