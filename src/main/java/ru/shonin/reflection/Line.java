package ru.shonin.reflection;

import java.util.Objects;

public class Line<T extends Point> implements Cloneable, CanReturnDistance{

    private T start;
    private T end;


    public Line(T start, T end){
        this.start = (T)start.clone();
        this.end = (T)end.clone();
    }

    public void setStart(T start) {
        this.start = (T) start.clone();
    }

    public void setEnd(T end) {
        this.end = (T)end.clone();
    }

    public T getStart() {
        return (T) start;
    }

    public T getEnd() {
        return (T) end;
    }

//    public Line(int x1, int y1, int x2, int y2){
//        this(new Point(x1,y1),new Point(x2,y2));
//    }

    public int getDistance(){
        return start.getDistance(end);
    }

    public String toString(){
        return "Start : " + start + " End: " + end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(start, line.start) && Objects.equals(end, line.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public Line clone(){
        return new Line(start.clone(),end.clone());
    }
}