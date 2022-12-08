package me.Kesims.Bank.card.serialization;

import me.Kesims.Bank.card.CreditCard;

import java.util.ArrayList;

public class CreditCardJsonSerializationObjectFactory {
    public CreditCardJsonSerializationObject createFromCreditCard(CreditCard card) {
        CreditCardJsonSerializationObject c = new CreditCardJsonSerializationObject();
        c.cardNumber = card.getCardNumber();
        c.cvc = card.getCvc();
        c.expiration = card.getExpiration();
        c.balanceLimit = card.getBalanceLimit();
        c.usedBalance = card.getUsedBalance();

        return c;
    }

    public ArrayList<CreditCardJsonSerializationObject> createListFromCardList(ArrayList<CreditCard> creditCards) {
        ArrayList<CreditCardJsonSerializationObject> c = new ArrayList<>();
        for(CreditCard card : creditCards) {
            c.add(createFromCreditCard(card));
        }

        return c;
    }
}
