package ru.shonin.reflection;

import ru.shonin.annotations.ToString;

@ToString
public class HumanTests {

    private void testAge(Human human) throws  ValidateException {
        if (human.getAge()<1 ||
            human.getAge()>200
            ){
            throw new ValidateException("возраст человека не в диапазоне от 1 до 200");}
    }

//    public String toString(){
//        return "test for human";
//    }
}
