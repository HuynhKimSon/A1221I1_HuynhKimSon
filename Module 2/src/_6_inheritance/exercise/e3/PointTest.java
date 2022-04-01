package _6_inheritance.exercise.e3;

import java.util.Arrays;

public class PointTest {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));

        point = new Point(2.1f, 3.5f);
        System.out.println(point);
        System.out.println(Arrays.toString(point.getXY()));
    }
}
