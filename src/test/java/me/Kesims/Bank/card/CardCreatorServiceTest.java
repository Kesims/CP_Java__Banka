package me.Kesims.Bank.card;

import com.google.inject.Guice;
import com.google.inject.Inject;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.bank.BankInjector;
import me.Kesims.Bank.bank.BankInjectorTest;
import me.Kesims.Bank.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardCreatorServiceTest {

    @Inject
    CardCreatorService cardCreatorService;

    @Inject
    CardStorageService cardStorageService;

    @BeforeEach
    public void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void testInjectBaseService() {
        assertNotNull(cardCreatorService);
        assertInstanceOf(CardCreatorService.class, this.cardCreatorService);
    }

    @Test
    void testAreServicesInjected() { // Check that the Mock is used
        assertNotNull(this.cardCreatorService);
        assertInstanceOf(CardFactory.class, this.cardCreatorService.getCardFactory());
        assertInstanceOf(CardNumberGeneratorServiceMock.class, this.cardCreatorService.getCardNumberGeneratorService());
    }

    @Test
    void createCardAndSetIntoAccount() {
        Person p = new Person("A", "B", 0);
        BaseAccount a = new BaseAccount("X", p , 0);
        BaseCard c = cardCreatorService.createCardAndSetIntoAccount(CardType.BaseCard, a);

        assertTrue(cardStorageService.cardList.contains(c));
        assertTrue(c.getAccount().getAccountCards().contains(c));
        assertSame(c.getAccount(), a);
    }
}