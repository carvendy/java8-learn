package com.carvendy.java8.ch05;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import com.carvendy.java8.ch04.Dish;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Before;
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
        //stream().count()
        System.out.println("sum:"+sum);

        Optional<Integer> reduce = nums.stream().reduce((a, b) -> a + b);
        System.out.println(reduce.get());
    }

    @Test
    public void min(){
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> reduce = nums.stream().reduce(Integer::min);
        System.out.println(reduce.get());

        int sum = nums.parallelStream().reduce(0, Integer::sum);
        //但要并行执行这段代码也要付一定代价
        //joining()

    }


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
    public void mapTo(){
        int sum = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum);

        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max(); //.orElse(-1)没有最大的时候
        System.out.println(maxCalories.getAsInt());
    }

    @Test
    public void range(){
        /* 不能使用，流使用了之后会自己关闭
        IntStream intStream = IntStream.range(1, 10);
        System.out.println(intStream.max()+"-"+intStream.min());*/

        OptionalInt max = IntStream.range(1, 10).max();
        System.out.println("max:"+max.getAsInt());
    }

    @Test
    public void triple(){
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 10).boxed()// 数据转为流
                        .flatMap(a ->
                                IntStream.rangeClosed(a, 10)// a\b交叉循环
                                        //.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                                        .mapToObj(b ->
                                                new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
                                        .filter(t -> t[2] % 1 == 0) //优化:　获取上一步生成的结果
                        );
        pythagoreanTriples.forEach(s -> System.out.println(s[0]+"-"+s[1]+"-"+s[2]));
    }

    @Test
    public void stream(){
        Stream.of("java 7","java 8","node 8")
            .map(String::toUpperCase).forEach(s -> System.out.println(s));
    }


    @Test
    public void file(){
        String path = StreamTest.class.getResource("/").getPath();

        long uniqueWords = 0;
        try(Stream<String> lines =
                Files.lines(Paths.get(path+"/data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()//生成单词流 删除重复项
                    .count();
        }
        //不相同的单词
        catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(uniqueWords);
    }


    @Test
    public void streamGen(){
       /*Stream.iterate(new int[]{0, 1},new int[]{0, 1})
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));*/
       Stream.generate(Math::random)
               .limit(5)
               .forEach(System.out::println);
    }



}