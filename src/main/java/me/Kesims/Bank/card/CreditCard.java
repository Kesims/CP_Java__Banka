package me.Kesims.Bank.card;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.card.BaseCard;

public class CreditCard extends BaseCard {

    private float balanceLimit;
    private float usedBalance;

    public CreditCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc, float balanceLimit) {
        super(baseAccount, cardNumber, expiration, cvc);
        setBalanceLimit(balanceLimit);
        setUsedBalance(0);
    }

    public float getBalanceLimit() {
        return this.balanceLimit;
    }

    public void setBalanceLimit(float balanceLimit) {
        if(balanceLimit < 0) {
            throw new IllegalArgumentException();
        }
        this.balanceLimit = balanceLimit;
    }

    public float getUsedBalance() {
        return usedBalance;
    }

    public void setUsedBalance(float usedBalance) {
        this.usedBalance = usedBalance;
    }
}
