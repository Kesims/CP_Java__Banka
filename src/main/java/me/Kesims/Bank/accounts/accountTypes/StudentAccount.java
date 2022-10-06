package me.Kesims.Bank.accounts.accountTypes;

import me.Kesims.Bank.person.Person;

public class StudentAccount extends BaseAccount implements InterestAccountInterface {


    public StudentAccount(String accountNumber, Person owner, float amount) {
        super(accountNumber, owner, amount);
    }
    @Override
    public float getInterest() {
        return 1;
    }
}
