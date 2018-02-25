package com.carvendy.java8.ch08.responsibility;

public class HeaderTextProcessing extends ProcessingObject<String> {

    public String handleWork(String text) {
        return "From Raoul, Mario and Alan: " + text;
    }

}