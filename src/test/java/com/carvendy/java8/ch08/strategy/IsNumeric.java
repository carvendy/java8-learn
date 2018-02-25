package com.carvendy.java8.ch08.strategy;

public class IsNumeric implements ValidationStrategy {

    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}