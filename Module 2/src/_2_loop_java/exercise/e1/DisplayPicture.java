package _2_loop_java.exercise.e1;

import java.util.Scanner;

public class DisplayPicture {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Print the rectangle");
                    for (int i = 0; i < 3; i++) {
                        for (int j = 1; j < 7; j++) {
                            System.out.print("*");
                        }
                        System.out.println("*");
                    }
                    break;
                case 2:
                    System.out.println("2. Print the square triangle");
                    for (int i = 1; i < 7; i++) {
                        for (int j = 1; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("*");
                    }
                    break;
                case 3:
                    System.out.println("3. Print isosceles triangle");
                    for (int i = 1; i <= 7; ++i) {
                        int k = 0;
                        for (int space = 1; space <= 7 - i; ++space) {
                            System.out.print(" ");
                        }
                        while (k != 2 * i - 1) {
                            System.out.print("*");
                            ++k;
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
