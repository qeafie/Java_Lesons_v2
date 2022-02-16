package ru.shonin.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Comparator;
import java.util.List;

@Configuration
@ComponentScan
public class FeedbackConfig {

    @Bean
    public Feedback goodFeedback(){
        return new Feedback("Очень хорошо",4);
    }

    @Bean
    public Feedback avgFeedback(){
        return new Feedback("Сойдет",3);
    }

    @Bean
    public Feedback badFeedback(int randomIntBean){
        return new Feedback("Сложно сказать", randomIntBean);
    }

    @Bean
    public Feedback bestFeedback(List<Feedback> feedbackList){
        return feedbackList.stream().max(Comparator.comparingInt(Feedback::getEstimation)).orElseThrow();
    }
}
