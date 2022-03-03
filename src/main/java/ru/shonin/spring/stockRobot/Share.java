package ru.shonin.spring.stockRobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Share {
    private double cost;
    private String name;
    List<Robot> robots = new ArrayList<>();

    public Share(double cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
        robots.forEach(Robot::act);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
@Component
 class ShareBuilder{
    @Autowired
    List<Robot> robots;

    public Share getShare(double cost,String name){
        Share sh= new Share(cost,name);
        for (Robot r: robots){
            if (r.getName().equals(name)){
                sh.robots.add(r);
            }
        }
        return sh;
    }
}