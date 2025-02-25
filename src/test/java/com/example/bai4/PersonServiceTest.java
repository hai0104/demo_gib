package com.example.bai4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    PersonService personService = new PersonService();

    @Test
    public void testThem() {
        Person person = new Person("1", "Hải", 23, 232323, 12, "Học");
        String exp = "Them thanh cong";
        String act = personService.add(person);
        Assertions.assertEquals(exp, act);
    }

    @Test
    public void testL(){
        Person person1 = new Person("1", "Hải", 23, 0, 12, "Học");
        Assertions.assertThrows(IllegalArgumentException.class,()->personService.add(person1));
    }
    @Test

    public void testL3(){
        Person person1 = new Person("1", "Hải", 23, 0, 12, "Học");
        Assertions.assertThrows(IllegalArgumentException.class,()->personService.add(person1));
    }
    @Test

    public void testL1(){
        Person person2 = new Person("1", "Hải", -1, 23, 12, "Học");
        Assertions.assertThrows(IllegalArgumentException.class,()->personService.add(person2));
    }
    @Test
    public void testdetrong(){
        Person person1 = new Person("1", "", -1, 0, 12, "Học");
        Assertions.assertThrows(IllegalArgumentException.class,()->personService.add(person1));
    }
    @Test
    public void testdetrong1(){
        Person person1 = new Person("", "sa", -1, 0, 12, "Học");
        Assertions.assertThrows(IllegalArgumentException.class,()->personService.add(person1));
    }


}