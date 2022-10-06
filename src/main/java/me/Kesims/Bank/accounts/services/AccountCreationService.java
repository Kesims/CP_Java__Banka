package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.AccountFactory;
import me.Kesims.Bank.accounts.AccountNumberGenerator;
import me.Kesims.Bank.accounts.AccountStorageService;
import me.Kesims.Bank.accounts.accountTypes.AccountType;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.person.Person;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountCreationService {

    @Inject
    AccountNumberGenerator accountNumberGenerator;

    @Inject
    AccountFactory accountFactory;

    @Inject
    AccountStorageService accountStorageService;


    public BaseAccount createAccount(AccountType type, Person person, float balance) {
        String accountNum = accountNumberGenerator.getRandomAccountNumber();

        BaseAccount account = switch(type) {
            case BaseAccount -> this.accountFactory.createBaseAccount(accountNum, person, balance);
            case SavingsAccount -> this.accountFactory.createSavingsAccount(accountNum, person, balance);
            case StudentAccount -> this.accountFactory.createStudentAccount(accountNum, person, balance);
        };

        accountStorageService.addAccount(account);

        return account;
    }
}
