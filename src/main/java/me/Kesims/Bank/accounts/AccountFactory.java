package me.Kesims.Bank.accounts;


import com.google.inject.Singleton;
import me.Kesims.Bank.person.Person;

@Singleton
public class AccountFactory {

    public BaseAccount createBaseAccount(String accountNumber, Person person, float balance) {
        return new BaseAccount(accountNumber, person, balance);
    }

    public StudentAccount createStudentAccount(String accountNumber, Person person, float balance) {
        return new StudentAccount(accountNumber, person, balance);
    }

    public SavingsAccount createSavingsAccount(String accountNumber, Person person, float balance) {
        return new SavingsAccount(accountNumber, person, balance);
    }
}
