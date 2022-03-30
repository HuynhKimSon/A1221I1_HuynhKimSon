package _5_access_modifier.practice.p2;

public class Car {

    private String name;

    private String engine;

    public static int numberOfCars;

    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

}
