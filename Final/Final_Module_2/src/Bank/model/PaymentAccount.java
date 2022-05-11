package Bank.model;

public class PaymentAccount extends Account {
    private int cardNumber;
    private double moneyAccount;

    public PaymentAccount() {
    }

    public PaymentAccount(int id, int code, String name, String createDate, int cardNumber, double moneyAccount) {
        super(id, code, name, createDate);
        this.cardNumber = cardNumber;
        this.moneyAccount = moneyAccount;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    @Override
    public String toString() {
        return super.toString() + cardNumber + "," + moneyAccount;
    }
}
