package org.spring.demo_springhomework2.repository;

import org.apache.ibatis.annotations.*;
import org.spring.demo_springhomework2.model.entity.Student;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number")
    })
//    @ResultMap("studentMapper")
    @Select("""
SELECT *from students  OFFSET #{offset} LIMIT #{size};
""")
    List<Student> getAllStudents(int offset, Integer size);
    @ResultMap("studentMapper")
    @Select("""
SELECT *from students where student_id = #{studentId};
""")
    Student getStudentById(long studentId);
}
