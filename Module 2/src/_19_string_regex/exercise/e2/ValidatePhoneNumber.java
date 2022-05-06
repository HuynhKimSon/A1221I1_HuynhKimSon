package _19_string_regex.exercise.e2;

import java.util.Scanner;

public class ValidatePhoneNumber {
    private static final String REGEX_PHONE_NUMBER = "^(09|03|07|08|05)+([0-9]{8})";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại : ");
        String className = scanner.nextLine();

        while (!className.matches(REGEX_PHONE_NUMBER)) {
            System.out.println("Nhập lại số điện thoại : ");
            className = scanner.nextLine();
        }
        System.out.println("Bạn đã nhập đúng format");
    }
}
