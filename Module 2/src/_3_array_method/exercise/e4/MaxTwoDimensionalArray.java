package _3_array_method.exercise.e4;

public class MaxTwoDimensionalArray {
    public static void main(String[] args) {
        int[][] arrayList = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}
        };
        int max = arrayList[0][0];
        for (int i = 0; i < arrayList.length; i++) {
            for (int j = 0; j < arrayList[i].length; j++) {
                if (arrayList[i][j] > max) {
                    max = arrayList[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất : " + max);
    }
}
