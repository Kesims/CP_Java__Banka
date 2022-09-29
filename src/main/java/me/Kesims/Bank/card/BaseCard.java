package me.Kesims.Bank.card;

import me.Kesims.Bank.accounts.BaseAccount;

public class BaseCard {

    private BaseAccount baseAccount;

    private String cardNumber;

    private String expiration;

    private String cvc;

    public BaseCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
        this.baseAccount = baseAccount;
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvc = cvc;
    }
}
