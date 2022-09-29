package me.Kesims.Bank.accounts;

import me.Kesims.Bank.person.Person;

public class SavingsAccount extends BaseAccount implements InterestAccountInterface {
    public SavingsAccount(Person owner, float startingBalance) {
        super(owner, startingBalance);
    }

    @Override
    public float getInterest() {
        return 5;
    }
}
