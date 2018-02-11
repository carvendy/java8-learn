package com.carvendy.java8.ch05;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
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


}
