package _3_array_method.practice.p2;

import java.util.Scanner;

public class SearchValueArray {
    public static void main(String[] args) {
        String listArray[] = {"A", "B", "C", "D", "E"};

        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tên sinh viên cần tìm : ");
        String name = input.nextLine();

        boolean flag = false;
        for (int i = 0; i < listArray.length; i++) {
            if (listArray[i].equals(name)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.print("Tên sinh viên đã được tìm thấy");
        } else System.out.print("Không tìm thấy tên sinh viên");
    }
}
