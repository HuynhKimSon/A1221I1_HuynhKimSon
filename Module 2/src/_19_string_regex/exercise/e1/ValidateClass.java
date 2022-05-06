package _19_string_regex.exercise.e1;

import java.util.Scanner;

public class ValidateClass {

    private static final String REGEX_CLASS = "^[C|A|P][0-9]{4}[G|H|I|K|L|M]$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên lớp : ");
        String className = scanner.nextLine();

        while (!className.matches(REGEX_CLASS)) {
            System.out.println("Nhập lại tên lớp : ");
            className = scanner.nextLine();
        }
        System.out.println("Bạn đã nhập đúng format");
    }
}
