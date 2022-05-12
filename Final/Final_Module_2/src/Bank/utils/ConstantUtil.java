package Bank.utils;

public interface ConstantUtil {
    interface PATH {
        String BANK_ACCOUNT = "src/Bank/data/bank_account.csv";
    }

    interface PROPERTIES {
        String CODE = "Mã tài khoản";
        String NAME = "Tên chủ tài khoản";
        String CREATE_DATE = "Ngày tạo tài khoản";

        // SAVING
        String SAVING_MONEY = "Số tiền gửi tiết kiệm";
        String SENT_DATE = "Ngày gửi tiết kiệm";
        String INTEREST_RATE = "Lãi xuất";
        String MONTH = "Kỳ hạn(số tháng)";

        // PAYMENT
        String CARD_NUMBER = "Số thẻ";
        String MONEY_ACCOUNT = "Số tiền trong tài khoản";
    }

}
