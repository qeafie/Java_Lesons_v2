package ru.shonin.reflection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsWriter {
    private File file;

    public ObjectsWriter(String fileName) {
        this.file = new File(fileName);
    }

    public void write(Object... objects)  {
        StringBuilder stringBuilder = new StringBuilder();

        for(Object obj: objects){
            stringBuilder.append(obj.toString()).append(" ");
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
