package _2_loop_java.exercise.e2;

import java.util.Scanner;

public class DisplayPrime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Số lượng số nguyên tố cần in : ");

        int numbers = input.nextInt();
        int count = 0;
        int i = 2;
        while (numbers > count) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }
}
