package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.BaseAccount;
import me.Kesims.Bank.accounts.InterestAccountInterface;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class InterestManagerService {

    InterestCalculator interestCalculator;
    public InterestManagerService() {
        interestCalculator = new InterestCalculator();
    }

    public void addInterests(ArrayList<BaseAccount> accounts) {
        for (BaseAccount account : accounts) {
            if (account instanceof InterestAccountInterface) {
                float amount = interestCalculator.calculateInterest(account);
                account.addBalance(amount);
            }
        }
    }
}
