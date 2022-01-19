package ru.shonin.reflection;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsWriter {
    private File fileName;

    public ObjectsWriter(File fileName) {
        this.fileName = fileName;
    }

    public void write(Object... objects){
        StringBuilder stringBuilder = new StringBuilder();

        for(Object obj: objects){
            stringBuilder.append(obj.toString()).append(" ");
        }

        //логика записи строки в файл


    }
}
