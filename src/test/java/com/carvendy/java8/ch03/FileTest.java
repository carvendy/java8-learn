package com.carvendy.java8.ch03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hailin
 * @description 文件操作
 * @date 2018/02/10
 */
public class FileTest {

    File file = new File("/tmp/test.txt");

    @Before
    public  void before() throws IOException {
        if(!file.exists()){
            file.createNewFile();
            System.out.println("创建test.txt");
        }
    }

    @Test
    public void file() throws Exception {
        System.out.println(oneLine());
        String result = fileProcess((BufferedReader br) ->
                br.readLine() + br.readLine());
        System.out.println(result);
    }

    public String oneLine() throws Exception{
        try(BufferedReader br = new BufferedReader( new FileReader(file))){
           return  br.readLine();
        }
    }

    public  String fileProcess(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader( new FileReader(file))){
            return  p.process(br);
        }
    }

}