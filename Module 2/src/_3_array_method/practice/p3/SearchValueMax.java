package _3_array_method.practice.p3;

import java.util.Arrays;
import java.util.Scanner;

public class SearchValueMax {
    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Nhập số lượng phần tử từ 0 đến 20 : ");
            size = input.nextInt();
        } while (size < 0 || size > 20);

        // Them phan tu vao mảng
        int listArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + " : ");
            int number = input.nextInt();
            listArray[i] = number;
        }
        System.out.println("Mang ban dau : " + Arrays.toString(listArray));

        // Tim phan tu lon nhat
        int max = listArray[0];
        for (int i = 1; i < listArray.length; i++) {
            if (listArray[i] > max) {
                max = listArray[i];
            }
        }
        System.out.println("Phan tu lon nhat trong mang : " + max);
    }
}
