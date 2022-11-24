package me.Kesims.Bank.card;

import me.Kesims.Bank.atms.BaseATM;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CardStorageService {

    List<BaseCard> cardList = new ArrayList<>();

    public void addCard(BaseCard card) {
        cardList.add(card);
    }

    public BaseCard findCard(String cardNumber) {
        for(BaseCard card : cardList) {
            if(card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

}
