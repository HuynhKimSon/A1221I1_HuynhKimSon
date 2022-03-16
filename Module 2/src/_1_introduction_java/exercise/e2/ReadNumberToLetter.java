package _1_introduction_java.exercise.e2;

import java.util.Scanner;

public class ReadNumberToLetter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số cần đọc : ");
        int number = input.nextInt();

        String name = new String();
        if (number < 0) {
            name = "out of ability";
        } else if (number < 10) {
            switch (number) {
                case 0:
                    name = "zero";
                    break;
                case 1:
                    name = "one";
                    break;
                case 2:
                    name = "two";
                    break;
                case 3:
                    name = "three";
                    break;
                case 4:
                    name = "four";
                    break;
                case 5:
                    name = "five";
                    break;
                case 6:
                    name = "six";
                    break;
                case 7:
                    name = "seven";
                    break;
                case 8:
                    name = "eight";
                    break;
                case 9:
                    name = "nine";
                    break;
            }
        }
        System.out.print("Result : " + name);
        input.close();
    }
}
