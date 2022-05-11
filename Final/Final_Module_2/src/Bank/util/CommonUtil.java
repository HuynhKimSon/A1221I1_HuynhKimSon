package Bank.util;

import java.util.Scanner;

public class CommonUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int choice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
        }
        return choice;
    }
}
