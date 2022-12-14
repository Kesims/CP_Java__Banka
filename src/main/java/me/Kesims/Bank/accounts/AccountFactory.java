package me.Kesims.Bank.accounts;


import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.accountTypes.SavingsAccount;
import me.Kesims.Bank.accounts.accountTypes.StudentAccount;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.person.PersonFactory;

@Singleton
public class AccountFactory {

    @Inject
    PersonFactory personFactory;

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
