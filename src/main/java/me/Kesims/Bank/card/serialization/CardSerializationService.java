package me.Kesims.Bank.card.serialization;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.Kesims.Bank.card.BaseCard;
import me.Kesims.Bank.card.CreditCard;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class CardSerializationService {

    @Inject
    CardJsonSerializationObjectFactory cardJsonSerializationObjectFactory;

    @Inject CreditCardJsonSerializationObjectFactory creditCardJsonSerializationObjectFactory;

    public List<CardJsonSerializationObject> getCardJsonSerializationObjectsFromCardList(List<BaseCard> allCards) {
        ArrayList<BaseCard> baseCards = new ArrayList<>();
        for(BaseCard card : allCards) {
            if(!(card instanceof CreditCard)) {
                baseCards.add(card);
            }
        }
        return cardJsonSerializationObjectFactory.createListFromCardList(baseCards);
    }

    public List<CreditCardJsonSerializationObject> getCreditCardJsonSerializationObjectsFromCardList(List<BaseCard> allCards) {
        ArrayList<CreditCard> creditCards = new ArrayList<>();
        for(BaseCard card : allCards) {
            if(!(card instanceof CreditCard)) {
                creditCards.add((CreditCard) card);
            }
        }
        return creditCardJsonSerializationObjectFactory.createListFromCardList(creditCards);
    }
}
