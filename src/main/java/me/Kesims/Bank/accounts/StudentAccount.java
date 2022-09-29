package me.Kesims.Bank.accounts;

import me.Kesims.Bank.person.Person;

public class StudentAccount extends BaseAccount implements InterestAccountInterface {

    private boolean isActiveStudent;

    public StudentAccount(Person owner, float amount, boolean isActiveStudent) {
        super(owner, amount);
        this.isActiveStudent = isActiveStudent;
    }

    public boolean isActiveStudent() {
        return isActiveStudent;
    }

    @Override
    public float getInterest() {
        return 1;
    }
}
