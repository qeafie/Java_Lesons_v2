package ru.shonin.spring.stock;

public class Bot implements ObserverStock {
    @Override
    public void update(Stock stock, int newPrice) {
        if(newPrice<=70){
            System.out.println("Нужно покупать " + stock.getTitle());
        }
    }
}
