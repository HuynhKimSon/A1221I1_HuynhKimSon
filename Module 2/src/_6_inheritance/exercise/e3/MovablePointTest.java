package _6_inheritance.exercise.e3;

import java.util.Arrays;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(1.0f, 2.0f, 3.0f, 4.0f);
        System.out.println(movablePoint);
    }
}
