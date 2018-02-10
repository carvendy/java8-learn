package com.carvendy.java8.ch02;

import com.carvendy.java8.ch01.Apple;
import java.util.List;

/**
 * 条件检查
 *
 * @author hailin
 * @date 2018/02/10
 */
public interface ApplePredicate {

    public boolean check(Apple apple);

}
