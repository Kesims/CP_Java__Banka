package me.Kesims.Bank.bank;

import com.google.inject.AbstractModule;
import me.Kesims.Bank.card.CardCreatorService;
import me.Kesims.Bank.card.CardNumberGeneratorService;
import me.Kesims.Bank.card.CardNumberGeneratorServiceMock;

import static org.junit.jupiter.api.Assertions.*;

public class BankInjectorTest extends AbstractModule {
    @Override
    public void configure() {
        super.configure();

        bind(CardNumberGeneratorService.class).to(CardNumberGeneratorServiceMock.class);
    }
}