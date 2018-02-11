package com.carvendy.java8.ch03;

import com.carvendy.java8.ch01.Apple;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/10
 */
public class BiFunctionTest {

    List<Apple> appList = new ArrayList<>();

    @Before
    public void before(){
        Apple b = new Apple("black", 123);
        Apple r = new Apple("red", 112);
        Apple g = new Apple("green", 120);

        appList.add(b);
        appList.add(r);
        appList.add(g);
    }

    /**
     * 比较器，链式
     */
    @Test
    public void comparator(){
        appList.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(appList);
    }

    /**
     * 类似数学上的复合函数
     */
    @Test
    public void mutilFunction(){
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g); //(1+1) * 2
        int result = h.apply(1);
        System.out.println(result);
    }

}
