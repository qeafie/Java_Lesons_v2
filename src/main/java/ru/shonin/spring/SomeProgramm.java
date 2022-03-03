package ru.shonin.spring;

import org.springframework.context.annotation.Bean;

public class SomeProgramm implements Programm{
    @Override
    public String doWork(String s) {
        return "someProgramm work";
    }
}
