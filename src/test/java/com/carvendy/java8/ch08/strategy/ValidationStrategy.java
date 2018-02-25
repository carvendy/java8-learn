package com.carvendy.java8.ch08.strategy;

public interface ValidationStrategy {
    boolean execute(String s);
}