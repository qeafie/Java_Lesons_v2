package ru.shonin.spring.stock;

public class Printer implements ObserverStock {
    @Override
    public void update(Stock stock, int newPrice) {
        System.out.println("Price has been update: before : "+stock.getPrice() +", after : "+ newPrice);
    }
}
