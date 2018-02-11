package com.carvendy.java8.ch03;

import com.carvendy.java8.ch01.Apple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * @author hailin
 * @description FunctionTest
 * @date 2018/02/10
 */
public class FunctionTest {

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for (T t:list){
            c.accept(t);
        }
    }

    /**
     *  处理程序
     */
    @Test
    public void consumer(){
        forEach(Arrays.asList(1,2,3,4,5),(i) -> System.out.println(i));

        System.out.println();
        // 返回函数,更简洁
        forEach(Arrays.asList("a", "b", "c", "d") ,System.out::print);
    }

    @Test
    public void init(){
        IntPredicate evenNumber = (int i) -> i % 2 == 0;// 没有装箱
        System.out.println("10:"+evenNumber.test(10));
    }


    private <T,R> List<R> match(List<T> list,Function<T,R> function){
        List<R> result = new ArrayList<>();
        for(T s: list){
            result.add(function.apply(s));
        }
        return result;
    }


    /**
     * 用于数据的提取、转换
     */
    @Test
    public void apply(){
        List<Character> list = match(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> {
            char c = (char) (i + 'a');
            return c;
        });

        System.out.println(list);
    }

    @Test
    public void method(){
        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(str);

        Supplier<Apple> c1 = () -> new Apple("white",123);
        System.out.println(c1.get());

        
    }

}
