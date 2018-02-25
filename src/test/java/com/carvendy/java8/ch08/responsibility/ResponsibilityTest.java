package com.carvendy.java8.ch08.responsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class ResponsibilityTest {

    @Test
    public void normal(){
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);

        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);
    }

    @Test
    public void lambda(){
        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");

        /**
         * 链路
         */
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);
        String result = pipeline.apply("Aren't labdas really sexy?!!");

        System.out.println(result);
    }


}
