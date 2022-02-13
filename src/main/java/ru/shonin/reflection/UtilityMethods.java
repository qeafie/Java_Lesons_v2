package ru.shonin.reflection;

import ru.shonin.annotations.Default;
import ru.shonin.annotations.Invoke;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Default(UtilityMethods.class)
public class UtilityMethods {
    //7.1.1
    public static List<String> fieldCollection(Object obj){
        List<String> lst = new ArrayList<>();

        for(Class clazz = obj.getClass(); clazz != null; clazz = clazz.getSuperclass()){
            for(Field field : clazz.getDeclaredFields()){
                field.setAccessible(true);
                lst.add(field.getName());
                field.setAccessible(false);
            }
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

        fieldStartPoint.setAccessible(false);
        fieldEndPoint.setAccessible(false);
    }

    //7.1.4
    @Invoke
    public static void validate(Object obj, Class<?> classObj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        List<Method> methods = new ArrayList<>(Arrays.asList(classObj.getDeclaredMethods()));


        Constructor constructor = classObj.getConstructor();
        Object obj1 = constructor.newInstance();
        for (Method method : methods) {
            try {
                method.setAccessible(true);
                method.invoke(obj1, obj);
                method.setAccessible(false);
            } catch (ValidateException e) {
                throw e;
            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

//        for (Method method : methods){
//            method.setAccessible(true);
//            method.invoke(obj1,obj);
//
//        }
    }
}
