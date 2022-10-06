package me.Kesims.Bank.accounts.accountTypes;

import org.checkerframework.checker.units.qual.A;

public enum AccountType {
    BaseAccount,
    SavingsAccount,
    StudentAccount;

    public static AccountType getAccountTypeFromClassname(String className) {
        switch (className) {
            case "SavingsAccount": return SavingsAccount;
            case "StudentAccount": return StudentAccount;
            default: return BaseAccount;
        }
    }
}
