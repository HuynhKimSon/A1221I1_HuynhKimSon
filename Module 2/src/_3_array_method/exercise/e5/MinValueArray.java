package _3_array_method.exercise.e5;

import java.util.Arrays;
import java.util.Scanner;

public class MinValueArray {
    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);

        // Nhập phần tử vào mảng A
        do {
            System.out.print("Nhập số lượng phần tử từ 0 đến 20 của mảng A : ");
            size = input.nextInt();
        } while (size < 0 || size > 20);

        int listArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + " của mảng A : ");
            int number = input.nextInt();
            listArray[i] = number;
        }
        System.out.println("Mảng A : " + Arrays.toString(listArray));
        int min = minValue(listArray);
        System.out.println("Phần tử nhỏ nhất : " + min);
    }

    public static int minValue(int[] listArray) {
        int min = listArray[0];
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i] < min) {
                min = listArray[i];
            }
        }
        return min;
    }
}
