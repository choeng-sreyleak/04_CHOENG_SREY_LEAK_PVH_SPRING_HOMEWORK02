package org.spring.demo_springhomework2.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.demo_springhomework2.model.entity.Instructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
//    private Instructor instructor;
    private Long instructorId;
}
