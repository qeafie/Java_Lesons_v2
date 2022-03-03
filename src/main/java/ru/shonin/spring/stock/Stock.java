package ru.shonin.spring.stock;

import java.util.*;

public class Stock implements PublisherStock {
    private final String title;
    private int price;

    private final List<ObserverStock> observers = new ArrayList<>();


    public Stock(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public void setPrice(int price) {
        if(price>=0){
            notifyObserver(this,price);
            this.price = price;
        }
        else throw new IllegalArgumentException();
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean addObserver(ObserverStock observer) {
        return observers.add(observer);
    }

    @Override
    public boolean deleteObserver(ObserverStock observer) {
        return observers.remove(observer);
    }

    @Override
    public void notifyObserver(Stock stock,int newPrice) {
        observers.forEach(x->x.update(this,price));
    }

    @Override
    public String toString() {
        return "Stock{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return price == stock.price && Objects.equals(title, stock.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}
