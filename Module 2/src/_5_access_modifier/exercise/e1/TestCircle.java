package _5_access_modifier.exercise.e1;

import java.util.Arrays;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(10);
        System.out.println(c1.getRadius());
        System.out.println(c1.getArea());
        System.out.println(c2.getRadius());
        System.out.println(c2.getArea());
    }
}
