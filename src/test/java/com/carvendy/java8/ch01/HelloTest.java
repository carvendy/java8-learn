package com.carvendy.java8.ch01;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class HelloTest {


    @Test
    public  void file(){
        File[] files = new File(".").listFiles(File::isHidden);//匿名函数=>简洁
        System.out.println(files.length);
    }

    @Test
    public void testFilter(){
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("red",151));
        list.add(new Apple("green",120));

        System.out.println(filterApples(list,Apple::isGreen));
        System.out.println(filterApples(list,Apple::isHeavy));

        /**
         * 代码干净，清晰
         */
        List<Apple> apples = filterApples(list, (Apple a) -> "red".equals(a.getColor()));
        System.out.println(apples);
        // 还有更好的API——Stream

    }

    public List<Apple> filterApples(List<Apple> list, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: list){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return  result;
    }


    @Test
    public void streamTest(){
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("red",151));
        list.add(new Apple("green",120));


        /**
         *  表面一等值，隐含二等值
         */
        List<Apple> collect = list.stream().filter((Apple a) -> a.getWeight() > 122).collect(toList());
        System.out.println(collect);

        /**
         * 并行
         */
        List<Apple> collect1 = list.parallelStream().filter((Apple a) -> "green".equals(a.getColor())).collect(toList());
        System.out.println(collect1);

        //list.sort();

        // 模式匹配
    }

}
