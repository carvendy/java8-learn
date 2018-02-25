package com.carvendy.java8.ch08.debug;

import static java.util.stream.Collectors.toList;

import com.carvendy.java8.ch08.Point;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class DebuggingTest {

    @Test
    public void error(){
        List<Point> points = Arrays.asList(new Point(12, 2), null);
        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }

    @Test
    public void peek(){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("===============");
        List<Integer> result =
                numbers.stream()
                        .peek(x -> System.out.println("from stream: " + x))
                        .map(x -> x + 17)
                        .peek(x -> System.out.println("after map: " + x))
                        .filter(x -> x % 2 == 0)
                        .peek(x -> System.out.println("after filter: " + x))
                        .limit(3)
                        .peek(x -> System.out.println("after limit: " + x))
                        .collect(toList());
    }

}