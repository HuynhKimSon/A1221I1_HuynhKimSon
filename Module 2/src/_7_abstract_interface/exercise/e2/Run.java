package _7_abstract_interface.exercise.e2;

public class Run {
    public static void main(String[] args) {
        int numberRandom = (int) Math.floor(Math.random() * 10);
        Square[] square = new Square[3];
        square[0] = new Square(numberRandom, "yellow", false);
        square[1] = new Square(numberRandom, "black", true);
        square[2] = new Square(numberRandom, "blue", false);
        for (Square item : square) {
            System.out.println(item);
        }
        System.out.println("\n");

    }
}
