package com.carvendy.java8.ch08.template;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

abstract class OnlineBanking {

    Map<Integer,Customer> data= new HashMap<>();
    {
        data.put(1,new Customer(1,"王一"));
        data.put(2,new Customer(1,"李二"));
        data.put(3,new Customer(1,"张三"));
    }


    public void processCustomer(int id) {
        Customer c = data.get(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);



}