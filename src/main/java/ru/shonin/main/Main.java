package ru.shonin.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.shonin.reflection.*;
import ru.shonin.spring.stock.Bot;
import ru.shonin.spring.stock.Printer;
import ru.shonin.spring.stock.Stock;
import ru.shonin.spring.Student;
import ru.shonin.spring.stockRobot.Robot;
import ru.shonin.spring.stockRobot.RobotImpl;
import ru.shonin.spring.stockRobot.SberRobot;
import ru.shonin.spring.stockRobot.Share;
import ru.shonin.spring.stockRobot.VTBRobot;
import ru.shonin.spring.trafficLight.Color;
import ru.shonin.spring.trafficLight.TrafficLight;

public class Main {
    public static void main(String[] args) throws Exception {

        //7.1.1
        B b = new B();
        System.out.println(UtilityMethods.fieldCollection(b));
        System.out.println("---------------");
        //7.1.2
        Line<Point> line1 = new Line<>(new Point(1,2),new Point(-5,-4));
        Line<Point> line2 = new Line<>(new Point(7,5),new Point(0,0));

        UtilityMethods.lineConnector(line1,line2);
        System.out.println(line1 + "\n" +  line2);
        System.out.println("---------------");
        //7.1.3
        System.out.println(new A());
        System.out.println(b);

        System.out.println("---------------");
        //7.1.4
        Human h = new Human(750);
        System.out.println(h);
        //UtilityMethods.validate(h,HumanTests.class);
        System.out.println("---------------");


        //7.1.5


        //7.3.1
        System.out.println(UtilityMethods.collect(A.class));
        System.out.println("---------------");

        // практика 15.02.2022


        ApplicationContext context = new AnnotationConfigApplicationContext("ru.shonin");
        (context.getBeansOfType(Student.class)).entrySet().forEach(System.out::println);
        System.out.println("---------------");


        //8.1.1
        System.out.println(context.getBean("helloBean"));
        System.out.println("---------------");

        //8.1.2

        System.out.println(context.getBean("randomIntBean"));
        System.out.println(context.getBean("randomIntBean"));
        System.out.println("---------------");

        //8.1.3

        System.out.println(context.getBean("dateBean"));
        System.out.println(context.getBean("dateBean"));
        System.out.println("---------------");

        System.out.println(context.getBean("predicateBean"));

        System.out.println(context.getBean("bestFeedback"));


        //17.02.2002

        //приложение при запуске собирает обработчики, ждёт ввода и что-то возвращает
        //построить метод doSomething чтобы можно было слабосвязно модифицировать программы(собирает програмы и вызывает ту на которую приходит строка)

        // научиться прослушивать tcp порты
        //следующая пара про настроийки бинов

        System.out.println("----------");
        Stock ORCLstock = new Stock("ORLC",75);
        Stock TSLAstock  = new Stock("TSLA",696);

        //Printer printer = new Printer();
        //ORCLstock.addObserver(printer);
        ///TSLAstock.addObserver(printer);

        ORCLstock.setPrice(65);

        Bot bot = new Bot();

        ORCLstock.addObserver(bot);

        ORCLstock.setPrice(65);

        System.out.println("----------");
//        context.getBeansOfType(Stock.class).entrySet().forEach(System.out::println);
//        TSLAstock.setPrice(65);

        //практика 03.03.2022

//        Share sh1 = ((ShareBuiler)context.getBean("ShareBuilder").getShare(0.01,"sber"));
//        Share sh2 = new Share(4,"vtb");
//
//
//
//        sh2.setCost(50);
//        sh2.setCost(0.5);
//
//
//        context.
//        TrafficLight trafficLight = new TrafficLight();
//        trafficLight.next();
//        trafficLight.next();
//        trafficLight.next();
//        trafficLight.next();


    }
}