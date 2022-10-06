package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.accountTypes.InterestAccountInterface;

public class InterestCalculator {
    public float calculateInterest(BaseAccount account) {
        if(!(account instanceof InterestAccountInterface)) throw new RuntimeException("This account has no interest.");

        float interest = ((InterestAccountInterface) account).getInterest();
        return ((account.getBalance()/100)*interest)/12;
    }
}
