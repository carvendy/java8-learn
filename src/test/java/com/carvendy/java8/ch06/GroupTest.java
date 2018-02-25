package com.carvendy.java8.ch06;

import com.carvendy.java8.ch04.Dish;
import com.carvendy.java8.ch04.Dish.Type;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static java.util.stream.Collectors.*;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class GroupTest extends CollectionTest{

    @Test
    public void group(){
        Map<Type, List<Dish>> dishesByType =
                menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        Map<Type, Long> collect = menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(collect);
    }

    /**
     * groupingBy(Dish::getType, counting())
     *    后面可以放聚合函数，所以可以进行再次分组。
     *    maxBy,suming
     */


}
