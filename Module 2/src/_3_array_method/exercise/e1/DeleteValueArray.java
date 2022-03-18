package _3_array_method.exercise.e1;


import java.util.Arrays;
import java.util.Scanner;

public class DeleteValueArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println("Mang ban dau : " + Arrays.toString(array));
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập phần tử cần xóa : ");
        int number = input.nextInt();

        int index_del = -1;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                index_del = i;
                break;
            }
        }
        System.out.println("index_del : " + index_del);
        if (index_del != -1) {
            for (; index_del < array.length - 1; index_del++) {
                array[index_del] = array[index_del + 1];
                System.out.println(array[index_del]);
            }
        }
        System.out.println("Mang ket qua : " + Arrays.toString(array));
    }
}
