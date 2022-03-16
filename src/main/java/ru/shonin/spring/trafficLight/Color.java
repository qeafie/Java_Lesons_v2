package ru.shonin.spring.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public  class Color {
    String currentColor;
    Color nextColor;

    public Color(String currentColor, Color nextColor) {
        this.currentColor = currentColor;
        this.nextColor = nextColor;
    }


    public Color(String currentColor) {
        this.currentColor = currentColor;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    @Autowired
    public Color getNextColor() {
        return nextColor;
    }

    public void setNextColor(Color nextColor) {
        this.nextColor = nextColor;
    }
}
