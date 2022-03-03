package ru.shonin.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Worker {
    public static String dothm(String s){
        String in[] = s.split("/");
        if(in.length!=2) return "wrong format";
        ApplicationContext context = new AnnotationConfigApplicationContext(ProgrammConfig.class);

        Programm programm = (Programm) context.getBean(in[0]);


        return programm.doWork(in[1]);
    }
}
