package ru.shonin.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProgrammConfig {

    @Bean
    Programm programmBean(){
        return new SomeProgramm();
    }
}
