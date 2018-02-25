package com.carvendy.java8.ch08.observer;

import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class ObserverTest {

    @Test
    public void normal(){
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }

    /**
     *  1.观察者的相关类可以取代
     *  2. 但是,观察者的逻辑有可能十分复杂,它们可能还持有状态,抑或定义了多个方法,诸如此类。
     *  在这些情形下,你还是应该继续使用类的方式。
     */
    @Test
    public void lambda(){
        Feed f = new Feed();
        f.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("money")){
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        f.registerObserver((String tweet) -> {
            if(tweet != null && tweet.contains("queen")){
                System.out.println("Yet another news in London... " + tweet);
            }
        });

        // queen
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }

}
