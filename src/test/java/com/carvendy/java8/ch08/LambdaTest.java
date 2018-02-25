package com.carvendy.java8.ch08;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author hailin
 * @description This is Description
 * @date 2018/02/25
 */
public class LambdaTest {

    @Test
    public void testMoveRightBy() throws Exception {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);
        assertEquals(15, p2.getX());
        assertEquals(5, p2.getY());
    }

    @Test
    public void testComparingTwoPoints(){
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);
        int result = Point.compareByXAndThenY.compare(p1 , p2);
        assertEquals(-1, result);
    }


    @Test
    public void testMoveAllPointsRightBy() throws Exception{
        List<Point> points =
                Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints =
                Arrays.asList(new Point(15, 5), new Point(20, 5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
       // assertEquals(expectedPoints, newPoints);//
    }


}
