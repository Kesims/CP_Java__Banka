package me.Kesims.Bank.card;

import com.google.inject.Guice;
import com.google.inject.Inject;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.services.MoneyTransferService;
import me.Kesims.Bank.bank.BankInjectorTest;
import me.Kesims.Bank.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardMoneyTransferServiceTest {

    @Inject
    CardCreatorService cardCreatorService;

    @Inject
    CreditCardMoneyTransferService creditCardMoneyTransferService;

    @BeforeEach
    void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void withdrawFromCreditCard() {
        Person p = new Person("A", "B", 321);
        BaseAccount acc = new BaseAccount("1234", p, 0);
        CreditCard c = new CreditCard(acc, "1234", "00/99", "123", 100.0f);
        assertTrue(creditCardMoneyTransferService.withdrawFromCreditCard(c, 5));
        assertFalse(creditCardMoneyTransferService.withdrawFromCreditCard(c, 96));
        assertEquals(100, c.getBalanceLimit());
        assertEquals(5, c.getUsedBalance());
    }

    @Test
    void transferMoneyToCreditCard() {
        Person p = new Person("A", "B", 321);
        BaseAccount acc = new BaseAccount("1234", p, 0);
        CreditCard c = new CreditCard(acc, "1234", "00/99", "123", 100.0f);
        c.setUsedBalance(25);
        assertFalse(creditCardMoneyTransferService.transferMoneyToCreditCard(c, 26));
        assertTrue(creditCardMoneyTransferService.transferMoneyToCreditCard(c, 25));
        assertEquals(0, c.getUsedBalance());
    }
}