package _1_introduction_java.exercise.e1;

import java.util.Scanner;

public class DisplayHello {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Hello: " + name);
        input.close();
    }
}
