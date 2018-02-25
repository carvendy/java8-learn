package com.carvendy.java8.ch08.observer;

interface Subject {

    void registerObserver(Observer o);

    void notifyObservers(String tweet);
}