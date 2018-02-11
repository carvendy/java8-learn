package com.carvendy.java8.ch04;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import com.carvendy.java8.ch04.Dish.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/11
 */
public class DishesTest {

    List<Dish> menu;

    @Before
    public void menu(){
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
    }


    /**
     * 集合 -> 流
     */
    @Test
    public void dishes(){
        //System.out.println(menu);
        List<String> list = menu.stream().
                filter(Dish::isVegetarian)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName).collect(toList());
        System.out.println(list);

        Set<String> set = menu.parallelStream() // 多核架构并行
                .filter((Dish d) -> d.getCalories() > 500)
                .sorted(Comparator.comparing(Dish::getName))
                .map(Dish::getName)
                .collect(toSet());
        System.out.println(set);

        Map<Type, List<Dish>> map = menu.parallelStream()
                .collect(groupingBy(Dish::getType));
        System.out.println(map);
    }


    /**
     * 调试的时候可以打印一些必要参数
     */
    @Test
    public void test(){
        Set<String> set = menu.parallelStream() // 多核架构并行
                .filter((Dish d) -> {
                    System.out.println(d.getName());
                    return d.getCalories() > 500;
                })
                .sorted(Comparator.comparing(Dish::getName))
                .map(Dish::getName)
                .collect(toSet());
    }


}