package ru.shonin.spring.stock;

public interface ObserverStock {
    void update(Stock stock, int newPrice);
}

