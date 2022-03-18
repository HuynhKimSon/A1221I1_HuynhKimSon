package _3_array_method.practice.p5;

import java.util.Arrays;

public class MethodSearchValueMin {
    public static void main(String[] args) {
        int[] arrayList = {1, 2, 3, 4, 5, 6, 7, 8};
        int value = minValue(arrayList);
        System.out.println("Phan tu nho nhat : " + value);

    }

    public static int minValue(int[] arrayList) {
        System.out.println("Mang ban dau : " + Arrays.toString(arrayList));
        int min = arrayList[0];
        for (int i = 1; i < arrayList.length; i++) {
            if (arrayList[i] < min) {
                min = arrayList[i];
            }
        }
        return min;
    }
}
