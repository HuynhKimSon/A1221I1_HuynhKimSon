package _6_inheritance.exercise.e1;

public class CylinderTest {

    public static void main(String[] args) {

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(10, 1.0, "black");
        System.out.println(cylinder);
    }
}
