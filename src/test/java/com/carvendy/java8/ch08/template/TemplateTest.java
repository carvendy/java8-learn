package com.carvendy.java8.ch08.template;

import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class TemplateTest {

    /***
     * 不用写多个实现类
     */
    @Test
    public void template(){
        new OnlineBankingLambda()
                .processCustomer(2, (Customer c) ->
                        System.out.println("Hello " + c.getName()));
    }

}
