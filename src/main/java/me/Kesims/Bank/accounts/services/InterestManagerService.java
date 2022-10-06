package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.AccountStorageService;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.accountTypes.InterestAccountInterface;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class InterestManagerService {
    InterestCalculator interestCalculator;

    @Inject
    private AccountStorageService accountStorageService;

    public InterestManagerService() {
        interestCalculator = new InterestCalculator();
    }

    public void addInterests() {
        for (BaseAccount account : accountStorageService.getAccounts()) {
            if (account instanceof InterestAccountInterface) {
                float amount = interestCalculator.calculateInterest(account);
                account.addBalance(amount);
            }
        }
    }
}
