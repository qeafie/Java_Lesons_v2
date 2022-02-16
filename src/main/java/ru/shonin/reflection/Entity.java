package ru.shonin.reflection;

import java.lang.reflect.Field;


public abstract class Entity {

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        String[] tempstr2 = getClass().toString().split("\\.");
        stringBuilder.append(tempstr2[tempstr2.length-1]);
        stringBuilder.append("{");

//        Class<? extends Entity> classEntity = getClass();
//        List<Field> fields = new ArrayList<>(Arrays.asList(classEntity.getDeclaredFields()));

//        for (Field field : fields){
//            field.setAccessible(true);
//            try {
//                stringBuilder.append(field.getName()).append(" = ").append(field.get(this));
//            } catch (IllegalAccessException e) {
//                System.out.println("IllegalAccessException");
//            }
//            if (fields.size()-1 > fields.indexOf(field))
//                stringBuilder.append(",");
//        }

        for(Class clazz = this.getClass(); clazz != null; clazz = clazz.getSuperclass()){
            for(Field field : clazz.getDeclaredFields()){
                field.setAccessible(true);
                try {
                    stringBuilder.append(field.getName()).append("=").append(field.get(this));
                } catch (IllegalAccessException e) {
                    System.out.println("IllegalAccessException");
                }
                    stringBuilder.append(", ");
            }

        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
