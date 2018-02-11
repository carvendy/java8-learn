package com.carvendy.java8.ch03;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 函数
 *
 * @author hailin
 * @date 2018/02/10
 */
@FunctionalInterface
public interface BufferedReaderProcessor{

    String process(BufferedReader b) throws IOException;

}
