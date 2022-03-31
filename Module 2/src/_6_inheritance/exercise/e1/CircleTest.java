package _6_inheritance.exercise.e1;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(1.0, "red");
        System.out.println(circle);
    }
}
