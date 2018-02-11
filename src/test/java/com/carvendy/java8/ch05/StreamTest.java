package com.carvendy.java8.ch05;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/11
 */
public class StreamTest {

    @Test
    public void list(){
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> words = Arrays.stream(arrayOfWords);

        // 不行
       /* List<String[]> list = words.map(streamOfword -> streamOfword.split(""))
                .map(Arrays::stream)
                .distinct().collect(toList());*/

        List<String> list = words.map(word -> word.split(""))
                .flatMap(Arrays::stream)// 合并
                .distinct()
                .collect(toList());
        System.out.println(list);
    }


    @Test
    public void arrays(){
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        List<int[]> arrays = numbers1.stream().flatMap(
                i -> numbers2.stream().map(j -> new int[]{i, j})
        ).collect(toList());

        arrays.forEach(ints -> System.out.println(ints[0]+","+ints[1]));
    }


    @Test
    public void match(){
        List<String> person = Arrays.asList("袭人", "晴雯", "宝玉");

        if(person.stream().anyMatch(s -> s.indexOf("玉") > -1)){
            System.out.println("其中一个有玉");
        }

        person = Arrays.asList("贾宝玉", "林黛玉", "蒋玉涵","妙玉");
        if(person.stream().anyMatch(s -> s.indexOf("玉") > -1)){
            System.out.println("全都有玉");
        }
        //noneMatch
        //findFirst()
    }

    @Test
    public void sum(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        int baseValue = 1;
        Integer sum = nums.stream().reduce(baseValue, (a, b) -> a + b);
        System.out.println("sum:"+sum);

        Optional<Integer> reduce = nums.stream().reduce((a, b) -> a + b);

    }


}