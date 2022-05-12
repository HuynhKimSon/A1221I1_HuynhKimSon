package Bank.utils;

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
                if (
                        fieldName.equals(ConstantUtil.PROPERTIES.CODE) ||
                                fieldName.equals(ConstantUtil.PROPERTIES.SAVING_MONEY) ||
                                fieldName.equals(ConstantUtil.PROPERTIES.INTEREST_RATE) ||
                                fieldName.equals(ConstantUtil.PROPERTIES.MONTH) ||
                                fieldName.equals(ConstantUtil.PROPERTIES.CARD_NUMBER) ||
                                fieldName.equals(ConstantUtil.PROPERTIES.MONEY_ACCOUNT)
                ) {
                    try {
                        if (Integer.parseInt(value) <= 0) {
                            value = "";
                            System.out.println(fieldName + " phải lớn hơn 0. Vui lòng nhập lại!");
                        }
                    } catch (NumberFormatException e) {
                        value = "";
                        System.out.println(fieldName + " không đúng kiểu dữ liệu. Vui lòng nhập lại!");
                    }
                }
                // Check format datetime
                if (fieldName.equals(ConstantUtil.PROPERTIES.CREATE_DATE) ||
                        fieldName.equals(ConstantUtil.PROPERTIES.SENT_DATE)) {
                    if (!Validation.isValidFormat("dd/MM/yyyy", value)) {
                        value = "";
                        System.out.println(fieldName + " phải đúng format dd/MM/yyyy. Vui lòng nhập lại!");
                    }
                }
            }
        } while (value.isEmpty() || value.isBlank());

        return value;
    }
}
