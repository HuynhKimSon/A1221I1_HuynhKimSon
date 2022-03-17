package _1_introduction_java.exercise.e3;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tỉ giá chuyển đổi (VND hoặc USD) : ");
        String rate = input.nextLine();
        String result = new String();

        if (rate.equals("USD") || rate.equals("VND")) {
            System.out.print("Nhập số tiền chuyển đổi : ");
            int amount = input.nextInt();
            int amountConvert;
            switch (rate) {
                case "VND":
                    amountConvert = amount / 23000;
                    result = "Giá trị chuyển đổi tỉ giá từ " + rate + " sang USD là : " + amountConvert;
                    break;
                case "USD":
                    amountConvert = amount * 23000;
                    result = "Giá trị chuyển đổi tỉ giá từ " + rate + " sang VND là : " + amountConvert;
                    break;
            }
        } else {
            result = "Tỉ giá cần chuyển đổi không đúng?";
        }
        System.out.print(result);
    }
}
