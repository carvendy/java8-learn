package com.carvendy.java8.ch02;

import com.carvendy.java8.ch01.Apple;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hailin
 * @description 参数化
 * @date 2018/02/10
 */
public class ParameterizationTest {

    List<Apple> appList = new ArrayList<>();

    @Before
    public void before(){
        Apple b = new Apple("black", 123);
        Apple r = new Apple("red", 110);
        Apple g = new Apple("green", 120);

        appList.add(b);
        appList.add(r);
        appList.add(g);
    }

    @Test
    public  void find(){
        System.out.println(findGreen(appList));
        System.out.println(findByColor(appList,"red"));
    }


    /**
     * 情况多的时候,声明接口类型
     */
    @Test
    public void findPredicate(){
        System.out.println(find(appList,new RedApplePredicate()));

        List<Apple> apples = find(appList, new ApplePredicate() {
            @Override
            public boolean check(Apple apple) {
                return "black".equals(apple.getColor());
            }
        });
        System.out.println(apples);

        List<Apple> predicate = findPredicate(appList,
                (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(predicate);
    }

    @Test
    public void sort(){
        appList.sort((Apple a,Apple b) ->{
            return a.getWeight().compareTo(b.getWeight());
        });
        System.out.println(appList);
    }

    private static List<Apple> findGreen(List<Apple> list){
        List<Apple> apples = new ArrayList<>();

        for(Apple apple:list){
            if("green".equals(apple.getColor())){
                apples.add(apple);
            }
        }
        return apples;
    }


    /**
     * 如果是多个属性,就使用多个find.
     *  不够灵活
     * @param list
     * @param color
     * @return
     */
    private static List<Apple> findByColor(List<Apple> list,String color){
        List<Apple> apples = new ArrayList<>();

        for(Apple apple:list){
            if(color.equals(apple.getColor())){
                apples.add(apple);
            }
        }
        return apples;
    }



    private static List<Apple> find(List<Apple> list,ApplePredicate ap){
        List<Apple> apples = new ArrayList<>();

        for(Apple apple:list){
            if(ap.check(apple)){
                apples.add(apple);
            }
        }
        return apples;
    }


    private static List<Apple> findPredicate(List<Apple> list,Predicate<Apple> ap){
        List<Apple> apples = new ArrayList<>();

        for(Apple apple:list){
            if(ap.test(apple)){
                apples.add(apple);
            }
        }
        return apples;
    }

}