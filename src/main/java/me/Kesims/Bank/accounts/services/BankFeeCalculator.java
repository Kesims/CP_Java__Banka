package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.accountTypes.SavingsAccount;
import me.Kesims.Bank.accounts.accountTypes.StudentAccount;

public class BankFeeCalculator {
    private final float FEE_BASE = 20;
    private final float FEE_STUDENT = 5;
    private final float FEE_SAVINGS = 50;

    public float getFee(BaseAccount account) {
        if(account instanceof StudentAccount) {
            return FEE_STUDENT;
        }
        else if(account instanceof SavingsAccount) {
            return FEE_SAVINGS;
        }
        return FEE_BASE;
    }

    public float deductPaymentFee(BaseAccount account, float amount) {
        float result = amount - getFee(account);
        return result < 0 ? 0:result;
    }
}
