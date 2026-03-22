package org.spring.demo_springhomework2.repository;

import org.apache.ibatis.annotations.*;
import org.spring.demo_springhomework2.model.entity.Student;
import org.spring.demo_springhomework2.model.request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id", id = true),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "org.spring.demo_springhomework2.repository.StudentCourseRepository.getCoursesByStudentId"))
    })
    @Select("""
        SELECT *from students
        OFFSET #{offset} LIMIT #{size}
    """)
    List<Student> getAllStudents(@Param("offset") int offset, @Param("size") int size);


    @Select("""
        SELECT *from students
        WHERE student_id = #{studentId}
    """)
    @ResultMap("studentMapper")
    Student getStudentById(Long studentId);

    @Insert("""
    INSERT INTO students (student_name, email, phone_number)
    VALUES (#{req.studentName}, #{req.email}, #{req.phoneNumber})
    RETURNING student_id;
""")
    Long createStudent(@Param("req") StudentRequest request);

    @Update("""
        UPDATE students
        SET student_name = #{req.studentName},
            email = #{req.email},
            phone_number = #{req.phoneNumber}
        WHERE student_id = #{studentId}
    """)
    void updateStudent(@Param("studentId") Long studentId, @Param("req") StudentRequest request);

    @Delete("DELETE FROM students WHERE student_id = #{studentId}")
    void deleteStudent(Long studentId);


}
