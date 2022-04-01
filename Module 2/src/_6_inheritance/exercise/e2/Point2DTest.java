package _6_inheritance.exercise.e2;

import java.util.Arrays;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));

        point2D = new Point2D(2.1f, 3.5f);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));
    }
}
