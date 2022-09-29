package me.Kesims.Bank.card;


import me.Kesims.Bank.accounts.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardCreatorService {

    @Inject
    private CardFactory cardFactory;

    public void createCardAndSetIntoAccount(BaseAccount baseAccount) {

        String cardNumber = "CARD_NUMBER"; // TODO generate
        String expiration = "EXP"; // TODO generate
        String cvc = "CVC"; // TODO generate

        BaseCard card = this.cardFactory.createBaseCard(baseAccount, cardNumber, expiration, cvc);
        baseAccount.addCard(card);
    }

}
