package me.Kesims.Bank.card;


import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.card.serialization.CardJsonSerializationObject;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class CardCreatorService {

    @Inject
    private CardNumberGeneratorService cardNumberGeneratorService;
    @Inject
    private CardFactory cardFactory;

    @Inject
    private CardStorageService cardStorageService;

    public BaseCard createCardAndSetIntoAccount(BaseAccount baseAccount) {

        String cardNumber = cardNumberGeneratorService.generateCardNumber();
        String expiration = cardNumberGeneratorService.generateExpiration();
        String cvc = cardNumberGeneratorService.generateCvc();

        BaseCard card = this.cardFactory.createBaseCard(baseAccount, cardNumber, expiration, cvc);
        baseAccount.addCard(card);
        cardStorageService.addCard(card);
        return card;
    }

    public void deserializeCardListAndSetIntoAccount(List<CardJsonSerializationObject> serializedCardList, BaseAccount account) {
        for(CardJsonSerializationObject serializedCard : serializedCardList) {
            deserializeCardAndSetIntoAccount(serializedCard, account);
        }
    }

    public void deserializeCardAndSetIntoAccount(CardJsonSerializationObject serializedCard, BaseAccount account) {
        BaseCard c = this.cardFactory.createBaseCard(account, serializedCard.cardNumber, serializedCard.expiration, serializedCard.expiration);
        account.addCard(c);
    }

    public CardFactory getCardFactory() {
        return cardFactory;
    }

    public CardNumberGeneratorService getCardNumberGeneratorService() {
        return cardNumberGeneratorService;
    }
}