package com.example.bai4;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private List<Person> list = new ArrayList<>();
//cscx
    // isblank : check trong, null, khoảng cách
    public String add(Person person) {
        if (person.getSalary() <= 0 || person.getSalary() > 200000000) {
            throw new IllegalArgumentException("luong nhan vien tu 200000000");
        } else if (person.getId().isBlank() || person.getName().isBlank() || person.getAge() < 0 || person.getSalary() <= 0) {
            throw new IllegalArgumentException("khong duoc de trong");

        } else {
            list.add(person);
            return "Them thanh cong";
        }
    }
}
