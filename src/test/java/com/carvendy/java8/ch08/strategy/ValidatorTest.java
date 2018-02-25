package com.carvendy.java8.ch08.strategy;

import org.junit.Test;

/**
 * @author hailin
 * @description 验证
 * @date 2018/02/25
 */
public class ValidatorTest {


    @Test
    public void normal(){
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase ());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b1+"-"+b2);
    }

    @Test
    public void lambda(){
        Validator numericValidator =
                new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator =
                new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b1+"-"+b2);
    }

}
