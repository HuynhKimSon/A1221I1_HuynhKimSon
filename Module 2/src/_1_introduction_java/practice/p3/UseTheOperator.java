package _1_introduction_java.practice.p3;

import java.util.Scanner;

public class UseTheOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);//Khai báo đối tượng Scanner

        System.out.print("Enter width: ");
        float width = scanner.nextFloat();//Nhập chiều rộng

        System.out.print("Enter height: ");
        float height = scanner.nextFloat();//Nhập chiều dài
        float area = width * height;

        System.out.println("Area is: " + area);
    }
}
