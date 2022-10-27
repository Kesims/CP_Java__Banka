package me.Kesims.Bank.accounts.accountTypes;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

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

    public static ArrayList<String> getTypesStringList() {
        ArrayList<String> result = new ArrayList<>();
        for(AccountType a : AccountType.values()) {
            result.add(a.name().replace("Account", ""));
        }
        return result;
    }
}
