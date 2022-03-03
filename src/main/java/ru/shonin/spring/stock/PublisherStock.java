package ru.shonin.spring.stock;

public interface PublisherStock {

    boolean addObserver(ObserverStock observer);
    boolean deleteObserver(ObserverStock observer);
    void notifyObserver(Stock stock, int newPrice);
}

