package me.Kesims.Bank.card;


import me.Kesims.Bank.accounts.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardCreatorService {

    @Inject
    private CardNumberGeneratorService cardNumberGeneratorService;
    @Inject
    private CardFactory cardFactory;

    public void createCardAndSetIntoAccount(BaseAccount baseAccount) {

        String cardNumber = cardNumberGeneratorService.generateCardNumber();
        String expiration = cardNumberGeneratorService.generateExpiration();
        String cvc = cardNumberGeneratorService.generateCvc();

        BaseCard card = this.cardFactory.createBaseCard(baseAccount, cardNumber, expiration, cvc);
        baseAccount.addCard(card);
    }

}
