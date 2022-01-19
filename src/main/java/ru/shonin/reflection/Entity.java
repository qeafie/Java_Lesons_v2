package ru.shonin.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Entity {

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        String[] tempstr2 = getClass().toString().split("\\.");
        stringBuilder.append(tempstr2[tempstr2.length-1]);
        stringBuilder.append("{");

        Class<? extends Entity> classEntity = getClass();
        List<Field> fields = new ArrayList<>(Arrays.asList(classEntity.getDeclaredFields()));
        for (Field field : fields){

            field.setAccessible(true);
            try {
                stringBuilder.append(field.getName()).append(" = ").append(field.get(this));
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException");
            }
            if (fields.size()-1 > fields.indexOf(field))
                stringBuilder.append(",");
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
