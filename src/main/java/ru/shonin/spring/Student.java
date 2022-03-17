package ru.shonin.spring;

import org.springframework.context.annotation.Configuration;
import ru.shonin.annotations.Default;

import java.util.function.Predicate;


public class Student {
    private int id;
    private String name;
    @Default(value = Integer.class)
    int test;

    @Default(value = String.class)
    String test2;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'+ test + test2;
    }
}
