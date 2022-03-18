package _3_array_method.exercise.e2;

import java.util.Arrays;
import java.util.Scanner;

public class AddValueArray {
    public static void main(String[] args) {
        int[] listArray = {1, 2, 3, 4, 5, 6, 0, 0, 0, 0};
        System.out.println("Mang ban dau : " + Arrays.toString(listArray));
        int[] listArrayNew = addArray(listArray);
        System.out.println("Mang ket qua : " + Arrays.toString(listArrayNew));
    }

    public static int[] addArray(int[] listArray) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap so can them : ");
        int number = input.nextInt();
        System.out.print("Nhap vi tri : ");
        int index = input.nextInt();

        // Khoi tao mang moi voi length = size + 1
        int size = listArray.length;
        int[] listArrayNew = new int[size + 1];

        if (index < 0) {
            System.out.println("Vi tri " + index + " khong duoc chen vao mang");
            return listArray;
        } else {
            for (int i = 0; i < listArrayNew.length; i++) {
                if (i < index) {
                    // sao chep phan tu: 0 -> vi tri index cua phan tu duoc them vao mang moi
                    listArrayNew[i] = listArray[i];
                } else if (i == index || index > listArray.length) {
                    // chen phan tu vao vi tri index hoac cuoi mang
                    listArrayNew[i] = number;
                } else {
                    // sao chep cac phan phia sau vi tri index vao mang moi
                    listArrayNew[i] = listArray[i - 1];
                }
            }
        }
        return listArrayNew;
    }
}
