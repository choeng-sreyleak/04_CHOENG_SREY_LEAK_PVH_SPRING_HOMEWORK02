package org.spring.demo_springhomework2.repository;

import org.apache.ibatis.annotations.*;
import org.spring.demo_springhomework2.model.entity.Course;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.spring.demo_springhomework2.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
 
 SELECT c.course_id, c.course_name, c.description, c.instructor_id
 FROM student_course sc
 INNER JOIN courses c ON sc.course_id = c.course_id
 WHERE sc.student_id = #{studentId};
    """)
    List<Course> getCoursesByStudentId (Long studentId);

    @Insert("INSERT INTO student_course (student_id, course_id) VALUES (#{studentId}, #{courseId})")
    void createStudentAndCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    @Delete("DELETE FROM student_course WHERE student_id = #{studentId}")
    void removeAllCourses(@Param("studentId") Long studentId);
}
