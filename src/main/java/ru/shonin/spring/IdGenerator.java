package ru.shonin.spring;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {
    private static int seed = 0;

    public static int next(){
        return seed++;
    }
}
