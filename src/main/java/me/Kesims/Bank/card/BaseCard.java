package me.Kesims.Bank.card;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;

public class BaseCard {

    private transient BaseAccount baseAccount; // Transient blokuje serializaci

    private String cardNumber;

    private String expiration;

    private String cvc;

    public BaseCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
        this.baseAccount = baseAccount;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvc;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public String getExpiration() {
        return expiration;
    }
    public String getCvc() {
        return cvc;
    }

    public BaseAccount getAccount() {
        return baseAccount;
    }
}
