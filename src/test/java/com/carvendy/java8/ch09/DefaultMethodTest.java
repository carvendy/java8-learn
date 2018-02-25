package com.carvendy.java8.ch09;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class DefaultMethodTest {

    /**
     * 1. 有点像抽象类,但不是.
     * 2. 默认方法的用户,主要是类库的设计者(Java API的演变)
     */
    @Test
    public void defaultMethod(){
        List<Integer> numbers = Arrays.asList(3, 5, 1, 2, 6);
        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);

        // 科里化
        System.out.println(curriedConverter(1,2).applyAsDouble(1));
    }


    static DoubleUnaryOperator curriedConverter(double f, double b){
        return (double x) -> x * f + b;
    }



}
