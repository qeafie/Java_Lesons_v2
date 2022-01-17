package ru.shonin.reflection;

import java.util.Objects;

public class Point implements Cloneable{
    private int x;
    private int y;


    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDistance(Point point){
        return (int)Math.sqrt(Math.pow((point.getX() - x),2) + Math.pow((point.getY() - y),2));
    }

    public String toString(){
        return "{" + x + ";" + y + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public Point clone(){
        return new Point(x,y);
    }
}
