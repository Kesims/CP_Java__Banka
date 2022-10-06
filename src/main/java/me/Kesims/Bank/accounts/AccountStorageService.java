package me.Kesims.Bank.accounts;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import org.checkerframework.checker.units.qual.A;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class AccountStorageService {
    private final ArrayList<BaseAccount> accounts = new ArrayList<>();

    public void addAccount(BaseAccount account) {
        this.accounts.add(account);
    }

    public ArrayList<BaseAccount> getAccounts() {
        return this.accounts;
    }

    public BaseAccount findAccount(String accountNumber) {
        for(BaseAccount account : accounts) {
            if(account.getAccountNumber().equals(accountNumber))
                return account;
        }
        return null;
    }
}
