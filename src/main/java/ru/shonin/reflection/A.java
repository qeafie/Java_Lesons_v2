package ru.shonin.reflection;

import ru.shonin.annotations.Invoke;

public class A extends Entity{
    String s ="hello";
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


