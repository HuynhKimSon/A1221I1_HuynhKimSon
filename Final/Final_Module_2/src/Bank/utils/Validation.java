package Bank.utils;

import Bank.service.BankService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    private static BankService bankService = new BankService();

    public static boolean isExitsAccount(int code) {
        return bankService.findAll().stream().anyMatch(e -> e.getCode() == code);
    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat temp = new SimpleDateFormat(format);
            date = temp.parse(value);    // parse : chuyển string thành date
            if (!value.equals(temp.format(date))) {     // format : chuyển date thành string
                date = null;
            }
        } catch (ParseException e) {
        }
        return date != null;
    }
}
