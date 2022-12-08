package me.Kesims.Bank.card;

import com.google.inject.Singleton;

@Singleton
public class CreditCardMoneyTransferService {
    public boolean withdrawFromCreditCard(CreditCard card, float amount) {
        if((card.getBalanceLimit()-card.getUsedBalance()) < amount) {
            card.setUsedBalance(card.getUsedBalance() + amount);
            return true;
        }
        return false;
    }

    public boolean transferMoneyToCreditCard(CreditCard card, float amount) {
        if(card.getUsedBalance() < amount) return false;
        card.setUsedBalance(card.getUsedBalance()-amount);
        return true;
    }
}
