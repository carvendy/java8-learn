package com.carvendy.java8.ch06;

import com.carvendy.java8.ch04.Dish;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import static java.util.stream.Collectors.*;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class PartitionTest extends CollectionTest {


    @Test
    public void part(){
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);
    }

    /**
     * 你可以将分区看做分组的一种特殊情况
     */
    @Test
    public void towPart(){
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType.get(true));
        System.out.println(vegetarianDishesByType.get(false));
    }


}
