package _15_exception.exercise.e1;

public class UseIllegalTriangleException {
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(-1, 2, 3);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
