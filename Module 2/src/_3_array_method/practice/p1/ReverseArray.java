package _3_array_method.practice.p1;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int size;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Nhập số lượng phần tử từ 0 đến 20 : ");
            size = input.nextInt();
        } while (size < 0 || size > 20);

        int listArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + " : ");
            int number = input.nextInt();
            listArray[i] = number;
        }
        System.out.println("Mang truoc : " + Arrays.toString(listArray));

        for (int i = 0; i < listArray.length / 2; i++) {
            int temp = listArray[i];
            listArray[i] = listArray[listArray.length - i - 1];
            listArray[listArray.length - i - 1] = temp;
        }
        System.out.print("Mang sau : " + Arrays.toString(listArray));
    }
}
