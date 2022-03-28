package ru.shonin.reflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.shonin.annotations.Default;
import ru.shonin.annotations.Invoke;

public class A extends Entity{
    @Default(String.class)
    String s ;
    int x = 42;

    @Invoke
    String m1(){
        return "text";
    }

    String m2(){return "place";}

    @Invoke
    Integer m3(){
        return 42;
    }
}


