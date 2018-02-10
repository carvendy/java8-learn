package com.carvendy.java8.ch02;

import com.carvendy.java8.ch01.Apple;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/10
 */
public class WeigthApplePredicate implements ApplePredicate {

    @Override
    public boolean check(Apple apple) {
        return 150 < apple.getWeight();
    }

}
