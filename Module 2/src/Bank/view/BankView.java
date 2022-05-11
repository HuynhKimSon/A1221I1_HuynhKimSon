package Bank.view;

import Bank.model.Account;
import Bank.model.PaymentAccount;
import Bank.model.SavingAccount;
import Bank.service.BankService;
import Bank.util.Validate;
import VehicleManagement.utils.CommonUtil;

import java.util.List;
import java.util.Scanner;

public class BankView {
    private static BankService bankService = new BankService();
    private static int choice;
    private static Scanner scanner = new Scanner(System.in);

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
                    display();
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
        System.out.print("Nhập Mã tài khoản: ");
        int code = Integer.parseInt(scanner.nextLine());
        List<Account> accounts = bankService.searchByCode(code);
        if (Validate.isExitsAccount(code)) {
            System.out.println("--TÀI KHOẢN CỦA BẠN---");
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
        } else {
            System.out.println("Không tìm thấy Mã tài khoản " + code);
        }
    }

    private static void delete() {
        display();
        System.out.println("--XÓA TÀI KHOẢN---");
        System.out.print("Nhập Mã tài khoản: ");
        int code = Integer.parseInt(scanner.nextLine());
        if (Validate.isExitsAccount(code)) {
            do {
                System.out.println("1. Có");
                System.out.println("2. Không");
                System.out.print("Chọn: ");
                choice = CommonUtil.choice();
                switch (choice) {
                    case 1:
                        boolean isDelete = bankService.delete(code);
                        if (isDelete) {
                            System.out.println("Xóa thành công mã tài khoản " + code);
                        } else {
                            System.out.println("Xóa thất bại. Không tìm thấy mã tài khoản " + code);
                        }
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Vui lòng xác nhận");
                        break;
                }
            } while (choice < 1 || choice > 2);

        } else {
            System.out.println("Không tìm thấy Mã tài khoản " + code);
        }
        display();
    }

    private static void display() {
        List<Account> accounts = bankService.findAll();
        System.out.println("--DANH SÁCH TÀI KHOẢN---");
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
            System.out.println("--THÊM MỚI TÀI KHOẢN---");
            System.out.println("1. Tài khoản tiết kiệm");
            System.out.println("2. Tài khoản thanh toán");
            System.out.print("Chọn : ");
            choice = CommonUtil.choice();
            int code = 0;
            String name = "";
            String createDate = "";
            if (choice == 1 || choice == 2) {
                System.out.print("Mã tài khoản: ");
                code = Integer.parseInt(scanner.nextLine());
                System.out.print("Tên chủ tài khoản: ");
                name = scanner.nextLine();
                System.out.print("Ngày tạo tài khoản: ");
                createDate = scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    System.out.print("Số tiền gửi tiết kiệm: ");
                    double savingMoney = Integer.parseInt(scanner.nextLine());
                    System.out.print("Ngày gửi tiết kiệm: ");
                    String sentDate = scanner.nextLine();
                    System.out.print("Lãi xuất: ");
                    double interestRate = Double.parseDouble(scanner.nextLine());
                    System.out.print("Kỳ hạn(số tháng): ");
                    int month = Integer.parseInt(scanner.nextLine());
                    account = new SavingAccount(0, code, name, createDate, savingMoney, sentDate, interestRate, month);
                    bankService.create(account);
                    break;
                case 2:
                    System.out.print("Số thẻ: ");
                    int cardNumber = Integer.parseInt(scanner.nextLine());
                    System.out.print("Số tiền trong tài khoản: ");
                    double moneyAccount = Double.parseDouble(scanner.nextLine());
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
