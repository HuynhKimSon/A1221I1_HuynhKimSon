package Bank.util;

import java.util.Scanner;

public class CommonUtil {
    public static String getScanner() {
        return new Scanner(System.in).nextLine();
    }

    public static int choice() {
        int choice = 0;
        try {
            choice = Integer.parseInt(CommonUtil.getScanner());
        } catch (Exception e) {
        }
        return choice;
    }
}
