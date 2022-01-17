package ru.shonin.main;

import ru.shonin.reflection.*;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //7.1.1
        B b = new B();
        System.out.println(UtilityMethods.fieldCollection(b));

        //7.1.2
        Line<Point> line1 = new Line<>(new Point(1,2),new Point(-5,-4));
        Line<Point> line2 = new Line<>(new Point(7,5),new Point(0,0));

        UtilityMethods.lineConnector(line1,line2);
        System.out.println(line1 + "\n" +  line2);

        //7.1.3
        System.out.println(new A());
        System.out.println(b);

    }
}