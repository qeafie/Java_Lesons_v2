package ru.shonin.spring.trafficLight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ColorConfig {

    @Bean
    Color red(Color rYellow){
        return new Color("red",rYellow);
    }

    @Bean
    @Qualifier("startColor")
    Color green(){
        return new Color("green");
    }

    @Bean
    Color gYellow(Color red){
        return new Color("yellow",red);
    }
    @Bean
    Color rYellow(Color green){
        return new Color("yellow",green);
    }

}
