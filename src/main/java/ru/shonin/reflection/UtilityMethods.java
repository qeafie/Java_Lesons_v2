package ru.shonin.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UtilityMethods {
    //7.1.1
    public static List<String> fieldCollection(Object obj){
        List<String> lst = new ArrayList<>();
        Class<?> classObj = obj.getClass();
        List<Field> fieldsObj = Arrays.asList(classObj.getFields());

        for(Field field:fieldsObj){
            lst.add(field.getName());
        }

        return lst;
    }
    //7.1.2

    public static void lineConnector(Line<?> line1, Line<?> line2) throws IllegalAccessException, NoSuchFieldException {
        Class<?> classLine = line1.getClass();
        Field fieldEndPoint = classLine.getDeclaredField("end");
        Field fieldStartPoint = classLine.getDeclaredField("start");
        fieldStartPoint.setAccessible(true);
        fieldEndPoint.setAccessible(true);

        Point point = (Point) fieldEndPoint.get(line1);
        fieldStartPoint.set(line2,point);
    }

    //7.1.4

}
