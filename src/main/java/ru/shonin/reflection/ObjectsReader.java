package ru.shonin.reflection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ObjectsReader<T> {
    private File fileName;

    public ObjectsReader(File fileName) {
        this.fileName = fileName;
    }

    public List<T> read(){
        List<T> lst =new ArrayList<>();
        return lst;
    }
}
