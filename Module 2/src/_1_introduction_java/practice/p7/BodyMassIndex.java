package _1_introduction_java.practice.p7;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.print("Your weight (in kilogram):");
        weight = scanner.nextDouble();

        System.out.print("Your height (in meter):");
        height = scanner.nextDouble();
        bmi = weight / Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");

        if (bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese"); // hiển thị tối đa 2 chữ số thập phân của số. Đầu ra sẽ chiếm ít nhất 20 ký tự. Nếu số chữ số không đủ, nó sẽ được đệm khoảng trắng bên phải
    }
}
