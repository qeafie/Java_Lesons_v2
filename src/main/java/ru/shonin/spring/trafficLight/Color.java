package ru.shonin.spring.trafficLight;

public class Color {
    String currentColor;
    Color nextColor;

    public Color (String color,Color nextColor){
        currentColor = color;
        this.nextColor = nextColor;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public Color getNextColor() {
        return nextColor;
    }

    public void setNextColor(Color nextColor) {
        this.nextColor = nextColor;
    }
}
