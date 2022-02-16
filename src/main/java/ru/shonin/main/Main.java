package ru.shonin.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shonin.reflection.*;
import ru.shonin.spring.Student;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws Exception {

        //7.1.1
        B b = new B();
        System.out.println(UtilityMethods.fieldCollection(b));
        System.out.println("---------------");
        //7.1.2
        Line<Point> line1 = new Line<>(new Point(1,2),new Point(-5,-4));
        Line<Point> line2 = new Line<>(new Point(7,5),new Point(0,0));

        UtilityMethods.lineConnector(line1,line2);
        System.out.println(line1 + "\n" +  line2);
        System.out.println("---------------");
        //7.1.3
        System.out.println(new A());
        System.out.println(b);

        System.out.println("---------------");
        //7.1.4
        Human h = new Human(750);
        System.out.println(h);
        //UtilityMethods.validate(h,HumanTests.class);
        System.out.println("---------------");


        //7.1.5


        //7.3.1
        System.out.println(UtilityMethods.collect(A.class));
        System.out.println("---------------");

        // практика 15.02.2022


        ApplicationContext context = new AnnotationConfigApplicationContext("ru.shonin");
        (context.getBeansOfType(Student.class)).entrySet().forEach(System.out::println);
        System.out.println("---------------");


        //8.1.1
        System.out.println(context.getBean("helloBean"));
        System.out.println("---------------");

        //8.1.2

        System.out.println(context.getBean("randomIntBean"));
        System.out.println(context.getBean("randomIntBean"));
        System.out.println("---------------");

        //8.1.3

        System.out.println(context.getBean("dateBean"));
        System.out.println(context.getBean("dateBean"));
        System.out.println("---------------");

        System.out.println(context.getBean("predicateBean"));

        System.out.println(context.getBean("bestFeedback"));
    }
}