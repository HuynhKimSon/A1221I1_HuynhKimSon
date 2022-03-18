package _3_array_method.exercise.e6;

import java.util.Scanner;

public class SumNumbers {
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
        } while (row < 0 || col < 0);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập giá trị cho vị trí " + "[" + i + "]" + "[" + j + "] : ");
                int number = input.nextInt();
                arrayList[i][j] = number;
            }
        }

        int colTotal;
        int total = 0;
        do {
            System.out.print("Nhập số cột cần tính tổng : ");
            colTotal = input.nextInt();
        } while (colTotal >= col);

        for (int i = 0; i < row; i++) {
            total += arrayList[i][colTotal];
        }

        System.out.print("Tổng của cột " + colTotal + " : " + total);
    }
}
