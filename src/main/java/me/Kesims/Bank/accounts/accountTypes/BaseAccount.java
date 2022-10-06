package me.Kesims.Bank.accounts.accountTypes;

import me.Kesims.Bank.card.BaseCard;
import me.Kesims.Bank.person.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseAccount {
    private float balance;
    private Person owner;
    private List<BaseCard> cards = new LinkedList<>();
    private String accountNumber;



    public BaseAccount(String accountNumber, Person owner, float initialBalance) {
        this.balance = initialBalance;
        this.owner = owner;
        this.accountNumber = accountNumber;
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

    public void addCard(BaseCard card) {
        this.cards.add(card);
    }

    public int getCardCount() {
        return this.cards.size();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public List<BaseCard> getAccountCards() {
        return this.cards;
    }
}
