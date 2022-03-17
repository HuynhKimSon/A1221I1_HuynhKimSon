package _2_loop_java.practice.p1;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập một số nguyên : ");
        int number = input.nextInt();

        String result = new String();
        boolean check = true;
        if (number < 2) {
            check = false;
        } else {
            if (number == 2) {
                check = true;
            } else {
                for (int i = 2; i < number; i++) {
                    if (number % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
        }
        if (check) {
            System.out.println("is a prime");
        } else {
            System.out.println("is not a prime");
        }
    }
}
