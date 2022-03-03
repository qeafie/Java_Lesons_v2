package ru.shonin.spring.stockRobot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RobotConfig {
    @Bean
    Robot sber(){
        return new RobotImpl("sber", new SberRobot());
    }
    @Bean
    Robot vtbBuy(){
        return new RobotImpl("vtb", new VTBRobot());
    }
    @Bean
    Robot vtbSell(){
        return new RobotImpl("vtb", new VTBRobot2());
    }
}
