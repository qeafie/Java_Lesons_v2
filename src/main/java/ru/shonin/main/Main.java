package ru.shonin.main;

import ru.shonin.reflection.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //7.1.1
        B b = new B();
        System.out.println(UtilityMethods.fieldCollection(b));
        System.out.println("---------------");
        //7.1.2
        Line<Point> line1 = new Line<>(new Point(1,2),new Point(-5,-4));
        Line<Point> line2 = new Line<>(new Point(7,5),new Point(0,0));

        UtilityMethods.lineConnector(line1,line2);
        System.out.println(line1 + "\n" +  line2);
        System.out.println("---------------");
        //7.1.3
        System.out.println(new A());
        System.out.println(b);

        System.out.println("---------------");
        //7.1.4
        Human h = new Human(750);
        System.out.println(h);
        //UtilityMethods.validate(h,HumanTests.class);
        System.out.println("---------------");

    }
}