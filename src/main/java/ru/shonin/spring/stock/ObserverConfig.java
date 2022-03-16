//package ru.shonin.spring.stock;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ObserverConfig {
//    @Bean
//    public ObserverStock obs1(List<Stock> stocks){
//        System.out.println(stocks);
//        return new Printer();
//    }
//    @Bean
//    public ObserverStock obs2(){
//        return new Bot();
//    }
//}
