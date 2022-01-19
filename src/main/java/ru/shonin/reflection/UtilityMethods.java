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
        Class<?> classObj = obj.getClass();
        Field[] fieldsObj = classObj.getFields();

        for(Field field:fieldsObj){
            field.setAccessible(true);
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
    @Invoke
    public static void validate(Object obj, Class<?> classObj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        List<Method> methods = new ArrayList<>(Arrays.asList(classObj.getDeclaredMethods()));
        Constructor constructor = classObj.getConstructor();
        Object obj1 = constructor.newInstance();
//        for (Method method : methods) {
//            try {
//                method.setAccessible(true);
//                method.invoke(obj);
//            } catch (ValidateException e) {
//                throw new Exception(e.getMessage());
//            } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
//                e.printStackTrace();
//            }
//        }

        for (Method method : methods){
            method.setAccessible(true);
            method.invoke(obj1,obj,obj);
        }
    }
}
