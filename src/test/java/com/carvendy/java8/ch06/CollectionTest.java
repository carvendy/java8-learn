package com.carvendy.java8.ch06;

import com.carvendy.java8.ch04.Dish;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author hailin
 * @description 流收集
 * @date 2018/02/25
 */
public class CollectionTest {

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


    @Test
    public void count(){
        Long collect = menu.stream().collect(counting());
        System.out.println(collect);
        long count = menu.stream().count();
        System.out.println(count);
    }


    @Test
    public void max(){
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> collect = menu.stream().collect(maxBy(dishCaloriesComparator));
        System.out.println(collect);
    }

    @Test
    public void sum(){
        //Collectors.summingInt
        Integer sum = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(sum);

        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);
    }

    @Test
    public void summary(){
        IntSummaryStatistics summaryStatistics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(summaryStatistics);
    }

    @Test
    public void string(){
        String lines = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println(lines);

    }

    // collect(Collectors.reducing)  stream.reduce()



}
