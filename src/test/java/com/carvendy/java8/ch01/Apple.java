package com.carvendy.java8.ch01;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Apple {

    private String color;
    private int weigth;

    public static boolean isGreen(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavy(Apple apple){
        return apple.getWeigth() > 150;
    }

}
