package Bank.view;

import Bank.exception.NotFoundException;
import Bank.model.Account;
import Bank.model.PaymentAccount;
import Bank.model.SavingAccount;
import Bank.service.BankService;
import Bank.utils.ConstantUtil;
import Bank.utils.Validation;
import Bank.utils.CommonUtil;

import java.util.List;

public class BankView {
    private static BankService bankService = new BankService();
    private static int choice;

    public static void main(String[] args) {
        while (true) {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG ---");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    List<Account> accounts = bankService.findAll();
                    display(accounts);
                    break;
                case 4:
                    searchByCode();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("---> Vui lòng chọn từ 1 -> 5");
                    break;
            }
        }
    }

    private static void searchByCode() {
        System.out.println("--TÌM KIẾM TÀI KHOẢN---");
        int code = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CODE));
        List<Account> findList = bankService.searchByCode(code);
        if (Validation.isExitsAccount(code)) {
            display(findList);
        } else {
            System.out.println("Không tìm thấy Mã tài khoản " + code);
        }
    }

    private static void delete() {
        List<Account> accounts = bankService.findAll();
        display(accounts);
        System.out.println("---XÓA TÀI KHOẢN---");
        int  code = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CODE));
        do {
            System.out.println("1. Có");
            System.out.println("2. Không");
            System.out.print("Chọn: ");
            choice = CommonUtil.choice();
            switch (choice) {
                case 1:
                    boolean isExists;
                    do {
                        try {
                            bankService.delete(code);
                            System.out.println("Xóa thành công mã tài khoản " + code);
                            isExists = false;
                        } catch (NotFoundException e) {
                            System.out.print(e.getMessage() + " Vui lòng nhập lại: ");
                            code = Integer.parseInt(CommonUtil.getScanner());
                            isExists = true;
                        }
                    } while (isExists);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Vui lòng xác nhận");
                    break;
            }
        } while (choice < 1 || choice > 2);
        display(accounts);
    }

    private static void display(List<Account> accounts) {
        System.out.println("---DANH SÁCH TÀI KHOẢN---");
        if (accounts.size() > 0) {
            for (Account a : accounts) {
                if (a instanceof SavingAccount) {
                    System.out.printf(
                            "Tài khoản tiết kiệm: id = %s, " +
                                    "Mã tài khoản = %s, " +
                                    "Tên chủ tài khoản = %s,  " +
                                    "Ngày tạo tài khoản = %s, " +
                                    "Số tiền gửi tiết kiệm = %s, " +
                                    "Ngày gửi tiết kiệm = %s, " +
                                    "Lãi suất = %s, " +
                                    "Kì hạn = %s\n"
                            , a.getId(), a.getCode(), a.getName(), a.getCreateDate(),
                            ((SavingAccount) a).getSavingMoney(), ((SavingAccount) a).getSentDate(),
                            ((SavingAccount) a).getInterestRate(), ((SavingAccount) a).getMonth());
                } else {
                    System.out.printf("Tài khoản thanh toán: id = %s, " +
                                    "Mã tài khoản = %s, " +
                                    "Tên chủ tài khoản = %s,  " +
                                    "Ngày tạo tài khoản = %s, " +
                                    "Số thẻ = %s, " +
                                    "Số tiền trong tài khoản = %s\n"
                            , a.getId(), a.getCode(), a.getName(), a.getCreateDate(),
                            ((PaymentAccount) a).getCardNumber(), ((PaymentAccount) a).getMoneyAccount());
                }
            }
        } else {
            System.out.println("Danh sách trống!");
        }
    }

    public static void create() {
        Account account;
        do {
            System.out.println("---THÊM MỚI TÀI KHOẢN---");
            System.out.println("1. Tài khoản tiết kiệm");
            System.out.println("2. Tài khoản thanh toán");
            System.out.print("Chọn : ");
            choice = CommonUtil.choice();
            int code = 0;
            String name = "";
            String createDate = "";
            if (choice == 1 || choice == 2) {
                code = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CODE));
                name = CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.NAME);
                createDate = CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CREATE_DATE);
            }
            switch (choice) {
                case 1:
                    double savingMoney = Double.parseDouble(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.SAVING_MONEY));
                    String sentDate = CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.SENT_DATE);
                    double interestRate = Double.parseDouble(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.INTEREST_RATE));
                    int month = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.MONTH));
                    account = new SavingAccount(0, code, name, createDate, savingMoney, sentDate, interestRate, month);
                    bankService.create(account);
                    break;
                case 2:
                    int cardNumber = Integer.parseInt(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.CARD_NUMBER));
                    double moneyAccount = Double.parseDouble(CommonUtil.inputWithoutEmpty(ConstantUtil.PROPERTIES.MONEY_ACCOUNT));
                    account = new PaymentAccount(0, code, name, createDate, cardNumber, moneyAccount);
                    bankService.create(account);
                    break;
                default:
                    System.out.println("Vui lòng chọn 1 hoặc 2");
                    break;
            }
        } while (choice < 1 || choice > 2);
        System.out.println("Thêm mới thành công!");
    }
}
