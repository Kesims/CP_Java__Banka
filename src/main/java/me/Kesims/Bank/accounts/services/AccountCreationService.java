package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.AccountFactory;
import me.Kesims.Bank.accounts.AccountNumberGenerator;
import me.Kesims.Bank.accounts.AccountType;
import me.Kesims.Bank.accounts.BaseAccount;
import me.Kesims.Bank.person.Person;
import org.checkerframework.checker.units.qual.A;

import javax.inject.Singleton;
import java.util.Random;

@Singleton
public class AccountCreationService {
    AccountNumberGenerator accountNumberGenerator;
    AccountFactory accountFactory;

    public AccountCreationService() {
        accountNumberGenerator = new AccountNumberGenerator();
        accountFactory = new AccountFactory();
    }

    public BaseAccount createAccount(AccountType type, Person person, float balance) {
        String accountNum = accountNumberGenerator.getRandomAccountNumber();

        BaseAccount account = switch(type) {
            case BaseAccount -> this.accountFactory.createBaseAccount(accountNum, person, balance);
            case SavingsAccount -> this.accountFactory.createSavingsAccount(accountNum, person, balance);
            case StudentAccount -> this.accountFactory.createStudentAccount(accountNum, person, balance);
        };

        return account;
    }
}
