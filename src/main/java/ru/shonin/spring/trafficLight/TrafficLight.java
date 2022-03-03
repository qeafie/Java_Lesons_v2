package ru.shonin.spring.trafficLight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrafficLight {
    @Autowired
            @Qualifier("startColor")
    Color currentColor;

    public void next(){
        System.out.println(currentColor.getCurrentColor());
        currentColor = currentColor.nextColor;
    }
}
