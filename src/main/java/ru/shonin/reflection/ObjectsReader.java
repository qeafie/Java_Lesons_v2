package ru.shonin.reflection;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectsReader<T> {
    private File file;

    public ObjectsReader(String fileName) {
        this.file = new File(fileName);
    }

    public List<T> read(){
        List<T> lst =new ArrayList<>();
        Class clazz;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            String[] mainStr = scanner.nextLine().split("\\{");
            String nameClass = mainStr[0];
            String anotherStr = mainStr[1].split("}")[0];

            clazz = Class.forName(nameClass);
            Object obj = new Object();
            clazz.cast(obj);
            Field[] fields = clazz.getDeclaredFields();

            for (Field field: fields){
                field.setAccessible(true);
                String[] fieldStr = anotherStr.split(", ");

                for(int i = 0; i < fieldStr.length; i++ ){
                    if(fieldStr[i].split("=")[0].equals(field.getName())){
                        Field fld = obj.getClass().getDeclaredField(field.getName());
                        //if ()
                        fld.set(obj,fieldStr[i].split("=")[1]);
                    }
                }



                field.setAccessible(false);
            }

            System.out.println(clazz);

        } catch (FileNotFoundException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        return lst;
    }
}
