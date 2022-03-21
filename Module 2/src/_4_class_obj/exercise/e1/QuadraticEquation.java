package _4_class_obj.exercise.e1;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

//    public double gettterA() {
//        return this.a;
//    }
//
//    public double gettterB() {
//        return this.b;
//    }
//
//    public double gettterC() {
//        return this.c;
//    }

    public double getDiscriminant() {
        return (this.b * 2 - 4 * this.a * this.c);
    }

    public double getRoot1() {
        return (-this.b + (Math.pow(getDiscriminant(), 0.5))) / 2 * this.a;
    }

    public double getRoot2() {
        return (-this.b - (Math.pow(getDiscriminant(), 0.5))) / 2 * this.a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a : ");
        double a = scanner.nextDouble();
        System.out.print("Enter b : ");
        double b = scanner.nextDouble();
        System.out.print("Enter c : ");
        double c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        double delta = quadraticEquation.getDiscriminant();
        System.out.println(delta);
        if (delta > 0) {
            // phuong trinh 2 nghiem
            System.out.println("The equation has two roots : " + quadraticEquation.getRoot1() + " and " + quadraticEquation.getRoot2());
        } else if (delta == 0) {
            // phuong trinh 2 nghiem bang nhau
            System.out.println("The equation has one roots : " + quadraticEquation.getRoot1());
        } else {
            System.out.print("The equation has no roots");
        }
    }
}
