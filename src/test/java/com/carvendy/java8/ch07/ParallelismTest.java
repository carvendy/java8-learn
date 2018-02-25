package com.carvendy.java8.ch07;

import java.util.function.Function;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class ParallelismTest {


    public long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    @Test
    public void normal(){
        /**
         * 　1. 拆箱，装箱
         *   2. iterate 很难并行
         */
        System.out.println(measureSumPerf(ParallelStreams::sequentialSum,1_000_000)+" msesc");

        // 性能更高
        System.out.println("Iterative sum done in:" +
                measureSumPerf(ParallelStreams::iterativeSum, 10_000_000) + " msecs");
    }

    @Test
    public void range(){
        System.out.println(measureSumPerf(ParallelStreams::rangedSum,10_000_000)+" msesc");
       // 并行更快
        System.out.println(measureSumPerf(ParallelStreams::parallelRangedSum,10_000_000)+" msesc");
    }


    @Test
    public void sum(){
        System.out.println("SideEffect sum done in: " +
                measureSumPerf(ParallelStreams::sideEffectSum, 10_000_000L) +" msecs" );

        // 答案不正确了
        System.out.println("SideEffect parallel sum done in: " +
                        measureSumPerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) +" msecs" );
    }


}
