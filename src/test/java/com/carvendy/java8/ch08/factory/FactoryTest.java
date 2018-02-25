package com.carvendy.java8.ch08.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class FactoryTest {

    final static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    @Test
    public void normal(){
        Product p = ProductFactory.createProduct("loan");

        /**
         * 多个参数的时候,map使用需要斟酌
         */
        Supplier<Product> p2 = map.get("loan");
        System.out.println(p2.get());
    }


}
