package Bank.model;

public class SavingAccount extends Account {
    private double savingMoney;
    private String sentDate;
    private double interestRate;
    private int month;

    public SavingAccount() {
    }

    public SavingAccount(int id, int code, String name, String createDate, double savingMoney, String sentDate, double interestRate, int month) {
        super(id, code, name, createDate);
        this.savingMoney = savingMoney;
        this.sentDate = sentDate;
        this.interestRate = interestRate;
        this.month = month;
    }

    public double getSavingMoney() {
        return savingMoney;
    }

    public void setSavingMoney(double savingMoney) {
        this.savingMoney = savingMoney;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return super.toString() + savingMoney + "," + sentDate + "," + interestRate + "," + month;
    }
}
