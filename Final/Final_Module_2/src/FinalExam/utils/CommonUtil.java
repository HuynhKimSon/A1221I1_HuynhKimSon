package FinalExam.utils;

import java.util.Scanner;

public class CommonUtil {

    public static String getScanner() {
        return new Scanner(System.in).nextLine();
    }


    public static int choice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(getScanner());
        } catch (Exception e) {
        }
        return choice;
    }


    public static String inputWithoutEmpty(String fieldName) {
        String value;
        do {
            System.out.print("Nhập " + fieldName + ": ");
            value = getScanner();
            if (value.isEmpty() || value.isBlank()) {
                System.out.println(fieldName + " trống. Vui lòng nhập lại!");
            } else {
                // Check format number
                if (fieldName.equals(ConstantUtil.PROPERTIES.PRICE) ||
                        fieldName.equals(ConstantUtil.PROPERTIES.QUALITY) ||
                        fieldName.equals(ConstantUtil.PROPERTIES.PRICE_IMPORT) ||
                        fieldName.equals(ConstantUtil.PROPERTIES.RATE_IMPORT) ||
                        fieldName.equals(ConstantUtil.PROPERTIES.PRICE_EXPORT)
                ) {
                    try {
                        if (Double.parseDouble(value) <= 0) {
                            value = "";
                            System.out.println(fieldName + " phải lớn hơn 0. Vui lòng nhập lại!");
                        }
                    } catch (NumberFormatException e) {
                        value = "";
                        System.out.println(fieldName + " không đúng kiểu dữ liệu. Vui lòng nhập lại!");
                    }
                }
            }
        } while (value.isEmpty() || value.isBlank());

        return value;
    }
}
