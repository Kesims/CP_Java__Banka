package me.Kesims.Bank.card;

import javax.inject.Singleton;

@Singleton
public class CardNumberGeneratorServiceMock extends CardNumberGeneratorService {
    @Override
    public String generateCardNumber() {
        return "12345678";
    }
}
