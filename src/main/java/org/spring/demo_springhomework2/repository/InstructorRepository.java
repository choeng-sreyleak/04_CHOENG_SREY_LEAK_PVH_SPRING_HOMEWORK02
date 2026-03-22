package org.spring.demo_springhomework2.repository;

import org.apache.ibatis.annotations.*;
import org.spring.demo_springhomework2.model.entity.Instructor;
import org.spring.demo_springhomework2.model.request.InstructorRequest;

import java.util.List;
@Mapper
public interface InstructorRepository {
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),


    })
    @Select("""
SELECT *from instructors  OFFSET #{offset} LIMIT #{size};
""")
    List<Instructor> getAllInstructors(Integer offset, Integer size);
    @ResultMap("instructorMapper")
    @Select("""
SELECT *from instructors where instructor_id = #{instructorId};
""")
    Instructor getInstructorById(Long instructorId);

    @ResultMap("instructorMapper")
    @Select("""
        INSERT INTO instructors VALUES ( default,#{req.instructorName},#{req.email}) RETURNING *;
    """)
    Instructor createInstructor(@Param("req") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Select("""
    UPDATE instructors SET instructor_name = #{req.instructorName}, email = #{req.email} WHERE instructor_id = #{instructorId} RETURNING *;
""")
    Instructor updateInstructorById(@Param("instructorId") Long instructorId,
                                    @Param("req") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Delete("""
    DELETE FROM instructors WHERE instructor_id = #{instructorId};
""")
    void deleteInstructorById(Long instructorId);


}
