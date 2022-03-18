package _3_array_method.exercise.e8;

import java.util.Scanner;

public class SumLetter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "abcdeaabc";
        System.out.print("Nhập ký tự cần đếm kí tự : ");
        String letter = input.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (letter.equals(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của kí tự " + letter + " : " + count);
    }
}
