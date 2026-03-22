package org.spring.demo_springhomework2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  Long studentId;
    private String studentName;
    private String email;
    private String phoneNumber;
}
