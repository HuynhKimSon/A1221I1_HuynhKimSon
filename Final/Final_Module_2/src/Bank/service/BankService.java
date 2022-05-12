package Bank.service;

import Bank.exception.NotFoundException;
import Bank.model.Account;
import Bank.model.PaymentAccount;
import Bank.model.SavingAccount;
import Bank.utils.ConstantUtil;
import Bank.utils.FileCSVHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankService {

    private List<Account> accounts = new ArrayList<>();
    private FileCSVHelper fileCSVHelper = new FileCSVHelper();

    public BankService() {
        accounts = mapToAccounts();
    }

    public void create(Account account) {
        int lastId = 0;
        if (accounts.size() > 0) {
            lastId = accounts.get(accounts.size() - 1).getId();
        }
        account.setId(lastId + 1);
        accounts.add(account);
        fileCSVHelper.write(Collections.singletonList(account), ConstantUtil.PATH.BANK_ACCOUNT, true);
    }

    public void delete(int code) throws NotFoundException {
        if (accounts.removeIf(e -> e.getCode() == code)) {
            fileCSVHelper.write(accounts, ConstantUtil.PATH.BANK_ACCOUNT, false);
        } else {
            throw new NotFoundException("Mã tài khoản " + code + " không tồn tại!");
        }
    }

    public List<Account> findAll() {
        return accounts;
    }

    public List<Account> searchByCode(int code) {
        List result = new ArrayList();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getCode() == code) {
                result.add(accounts.get(i));
            }
        }

        return result;
    }

    private List<Account> mapToAccounts() {
        List result = new ArrayList();

        List<String> lines = fileCSVHelper.read(ConstantUtil.PATH.BANK_ACCOUNT);
        for (String line : lines) {
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            int code = Integer.parseInt(tmp[1]);
            String name = tmp[2];
            String createDate = tmp[3];

            if (tmp.length == 6) {
                int cardNumber = Integer.parseInt(tmp[4]);
                double moneyAccount = Double.parseDouble((tmp[5]));
                result.add(new PaymentAccount(id, code, name, createDate, cardNumber, moneyAccount));
            } else {
                double savingMoney = Double.parseDouble((tmp[4]));
                String sentDate = tmp[5];
                double interestRate = Double.parseDouble((tmp[6]));
                int month = Integer.parseInt(tmp[7]);
                result.add(new SavingAccount(id, code, name, createDate, savingMoney, sentDate, interestRate, month));
            }
        }
        return result;
    }
}
