package me.Kesims.Bank.accounts;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import org.checkerframework.checker.units.qual.A;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Singleton
public class AccountStorageService {
    private final HashMap<String, BaseAccount> accounts = new HashMap<>();

    public void addAccount(BaseAccount account) {
        this.accounts.put(account.getAccountNumber(), account);
    }

    public List<BaseAccount> getAccounts() {
        return new ArrayList<>(this.accounts.values());
    }

//    public BaseAccount findAccount(String accountNumber) {
//        for(BaseAccount account : accounts) {
//            if(account.getAccountNumber().equals(accountNumber))
//                return account;
//        }
//        return null;
//    }

    public BaseAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}