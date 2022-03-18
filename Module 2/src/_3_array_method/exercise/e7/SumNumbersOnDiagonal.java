package _3_array_method.exercise.e7;

import java.util.Scanner;

public class SumNumbersOnDiagonal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] arrayList;
        int row;
        int col;
        do {
            System.out.print("Nhập số dòng : ");
            row = input.nextInt();
            System.out.print("Nhập số cột : ");
            col = input.nextInt();
            arrayList = new int[row][col];
        } while (row != col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập giá trị cho vị trí " + "[" + i + "]" + "[" + j + "] : ");
                int number = input.nextInt();
                arrayList[i][j] = number;
            }
        }

        int total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    total += arrayList[i][i];
                }
            }
        }

        System.out.print("Tổng của đường chéo của mảng 2 chiều : " + total);
    }
}
