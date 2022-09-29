package me.Kesims.Bank.accounts;

import me.Kesims.Bank.person.Person;

public class BaseAccount {
    private float balance;
    private Person owner;

    public BaseAccount(Person owner, float initialBalance) {
        this.balance = initialBalance;
        this.owner = owner;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }

    public void addBalance(float amount) {
        this.balance += amount;
    }

    public boolean removeBalance(float amount) {
        if(amount > balance) return false;
        balance -= amount;
        return true;
    }

    public Person getOwner() {
        return owner;
    }
}
