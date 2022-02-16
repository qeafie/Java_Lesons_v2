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
import java.util.Map;
import java.util.stream.Collectors;

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




    //7.3.1.

    public static Map<String,Object> collect(Class<?> clazz){
        return getMethods(clazz).stream().collect(Collectors.toMap(Method::getName, method -> invoke(method, newInstance(clazz))));
    }

    private static List<Method> getMethods(Class<?> clazz){
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(x-> x.isAnnotationPresent(Invoke.class))
                .filter(x->x.getParameters().length == 0)
                .filter(x->!x.getReturnType().equals(Void.TYPE))
                .collect(Collectors.toList());
    }

    private static Object invoke(Method method, Object object){
        try {
            method.setAccessible(true);
            return method.invoke(object);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object newInstance(Class clazz) {
        Object object = null;
        try {
            object = clazz.getConstructor().newInstance();
        } catch (InvocationTargetException | InstantiationException
                | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return object;
    }

}
