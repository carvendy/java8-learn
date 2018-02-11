package com.carvendy.java8.ch04;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/11
 */
@Data
@AllArgsConstructor
public class Dish {

    private String name;
    private  boolean vegetarian;
    private int calories;
    Type type;

    public enum Type { MEAT, FISH, OTHER }
}
