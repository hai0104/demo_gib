package com.example.bai4;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Person {
    private String id;
    private String name;
    private int age;
    private float salary;
    private int yearsOfWork;
    private String department;
}
