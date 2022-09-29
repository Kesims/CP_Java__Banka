package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.BaseAccount;
import me.Kesims.Bank.accounts.SavingsAccount;
import me.Kesims.Bank.accounts.StudentAccount;

import javax.inject.Singleton;

@Singleton
public class AccountInfoPrinterService {
    public void printAccountBalance(BaseAccount account) {
        System.out.println("Balance of " + account.getOwner().getFullName() + " is " + account.getBalance());
    }

    private String getTypePrefix(BaseAccount account) {
        if (account instanceof StudentAccount) {
            return "[Student] ";
        }

        if (account instanceof SavingsAccount) {
            return "[Saving] ";
        }

        return "[Base] ";
    }
}