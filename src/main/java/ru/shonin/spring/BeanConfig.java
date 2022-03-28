package ru.shonin.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;
import java.util.function.Predicate;


@Configuration
public class BeanConfig {
    //8.1.1
    @Bean
    public String helloBean(){return "Hello World";}

    //8.1.2
    @Bean
    @Scope("prototype")
    @Qualifier("randomInt")
    public Integer randomIntBean( int minBean, int maxBean){

        return (int) (Math.random() * maxBean) + minBean;
    }


    //8.1.3

    @Bean
    public Date dateBean(){
        return new Date();
    }

    //8.1.4

    @Bean
    public Predicate<Integer> predicateBean(){
        return x->x>=2 && x<=5;
    }

    //8.1.5
    @Bean
    public int maxBean(){
        return 42;
    }

    @Bean
    public int minBean(){
        return -1;
    }





}
