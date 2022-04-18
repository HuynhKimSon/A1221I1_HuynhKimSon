package _7_abstract_interface.exercise.e1;

public class Run {
    public static void main(String[] args) {
        int numberRandom = (int) Math.floor(Math.random() * 10);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(numberRandom, "yellow", false);
        shapes[1] = new Rectangle(numberRandom, numberRandom, "black", true);
        shapes[2] = new Square(numberRandom, "blue", false);
        for (Shape item : shapes) {
            System.out.println(item);
        }

        for (Shape percent : shapes) {
            percent.resize(Math.random() * 1000);
        }
        System.out.println("\n");
    }
}
