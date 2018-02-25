package com.carvendy.java8.ch08.responsibility;

public class SpellCheckerProcessing extends ProcessingObject<String> {

    public String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }

}