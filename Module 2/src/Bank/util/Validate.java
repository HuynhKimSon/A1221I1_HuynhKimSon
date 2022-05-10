package Bank.util;

import Bank.service.BankService;


public class Validate {
    private static BankService bankService = new BankService();

    public static boolean isExitsAccount(int code) {
        return bankService.findAll().stream().anyMatch(e -> e.getCode() == code);
    }
}
