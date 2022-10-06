package me.Kesims.Bank.card.serialization;

import me.Kesims.Bank.card.BaseCard;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class CardJsonSerializationObjectFactory {

    public CardJsonSerializationObject createFromCard(BaseCard card) {
        CardJsonSerializationObject c = new CardJsonSerializationObject();
        c.cardNumber = card.getCardNumber();
        c.cvc = card.getCvc();
        c.expiration = card.getExpiration();

        return c;
    }

    public ArrayList<CardJsonSerializationObject> createListFromCardList(ArrayList<BaseCard> baseCards) {
        ArrayList<CardJsonSerializationObject> c = new ArrayList<>();
        for(BaseCard card : baseCards) {
            c.add(createFromCard(card));
        }

        return c;
    }
}
