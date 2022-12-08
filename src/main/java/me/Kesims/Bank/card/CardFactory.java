package me.Kesims.Bank.card;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class CardFactory {

    public BaseCard createBaseCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc) {
        return new BaseCard(baseAccount, cardNumber, expiration, cvc);
    }

    public CreditCard createCreditCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc, float balanceLimit) {
        return new CreditCard(baseAccount, cardNumber, expiration, cvc, balanceLimit);
    }
}
