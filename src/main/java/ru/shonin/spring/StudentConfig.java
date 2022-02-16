package ru.shonin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public Student student1(){
        return new Student(IdGenerator.next(),"petya");
    }
    @Bean
    public Student student2(){
        return new Student(IdGenerator.next(),"vanya");
    }
    @Bean
    public Student student3(){
        return new Student(IdGenerator.next(),"kolya");
    }
}
