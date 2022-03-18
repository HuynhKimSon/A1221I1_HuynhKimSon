package _3_array_method.exercise.e3;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int sizeArrayListA;
        int sizeArrayListB;
        Scanner input = new Scanner(System.in);

        // Nhập phần tử vào mảng A
        do {
            System.out.print("Nhập số lượng phần tử từ 0 đến 20 của mảng A : ");
            sizeArrayListA = input.nextInt();
        } while (sizeArrayListA < 0 || sizeArrayListA > 20);

        int listArrayA[] = new int[sizeArrayListA];
        for (int i = 0; i < sizeArrayListA; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + " của mảng A : ");
            int number = input.nextInt();
            listArrayA[i] = number;
        }
        System.out.println("Mảng A : " + Arrays.toString(listArrayA));

        // Nhập phần tử vào mảng B
        do {
            System.out.print("Nhập số lượng phần tử từ 0 đến 20 của mảng B : ");
            sizeArrayListB = input.nextInt();
        } while (sizeArrayListB < 0 || sizeArrayListB > 20);

        int listArrayB[] = new int[sizeArrayListB];
        for (int i = 0; i < sizeArrayListB; i++) {
            System.out.print("Nhập số thứ " + (i + 1) + " của mảng B : ");
            int number = input.nextInt();
            listArrayB[i] = number;
        }
        System.out.println("Mảng B : " + Arrays.toString(listArrayB));

        // Mảng kết quả
        int[] listArrayC = merge(listArrayA, listArrayB);
        System.out.println("Mảng kết quả : " + Arrays.toString(listArrayC));
    }

    public static int[] merge(int[] listArrayA, int[] listArrayB) {
        int[] listArrayC = new int[listArrayA.length + listArrayB.length];
        // Thêm phần tử mảng A vào mảng C
        for (int i = 0; i < listArrayA.length; i++) {
            listArrayC[i] = listArrayA[i];
        }
        // Thêm phần tử mảng B vào mảng C
        int index = listArrayB.length;
        for (int i = 0; index < listArrayC.length; index++, i++) {
            listArrayC[index] = listArrayB[i];
        }
        return listArrayC;
    }
}
