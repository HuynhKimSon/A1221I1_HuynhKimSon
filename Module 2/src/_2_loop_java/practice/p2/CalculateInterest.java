package _2_loop_java.practice.p2;

import java.util.Scanner;

public class CalculateInterest {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;

        Scanner input = new Scanner(System.in);
        System.out.print("Nhập số tiền gửi : ");
        money = input.nextDouble();
        System.out.print("Nhập số tháng gửi : ");
        month = input.nextInt();
        System.out.print("Nhập số lãi suất : ");
        interestRate = input.nextDouble();

        double totalInterest = 0;

        for (int i = 1; i <= month; i++) {
            totalInterest += money * (interestRate / 100) / 12 * month;
        }
        System.out.print("Tổng lãi suất : " + totalInterest);
    }
}
