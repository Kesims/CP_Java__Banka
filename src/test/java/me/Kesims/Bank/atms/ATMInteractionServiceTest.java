package me.Kesims.Bank.atms;

import com.google.inject.Guice;
import com.google.inject.Inject;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.bank.BankInjectorTest;
import me.Kesims.Bank.card.BaseCard;
import me.Kesims.Bank.card.CreditCard;
import me.Kesims.Bank.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMInteractionServiceTest {
    @Inject
    ATMInteractionService atmInteractionService;

    @BeforeEach
    void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void accountWithdrawMoneyByCard() throws Exception {
        BaseATM atm = new BaseATM("Test");
        Person p = new Person("A", "B", 321);
        BaseAccount acc = new BaseAccount("12345", p, 125);
        CreditCard c = new CreditCard(acc, "1234", "00/99", "123", 100.0f);
        BaseCard b = new BaseCard(acc, "4321", "00/99", "123");

        atm.injectCard(c);
        assertTrue(atmInteractionService.accountWithdrawMoneyByCard(atm, 50));
        assertFalse(atmInteractionService.accountWithdrawMoneyByCard(atm, 6546));
        assertEquals(50, c.getUsedBalance());
        assertEquals(125, acc.getBalance());
        atm.ejectCard();
        atm.injectCard(b);
        assertTrue(atmInteractionService.accountWithdrawMoneyByCard(atm, 25));
        assertFalse(atmInteractionService.accountWithdrawMoneyByCard(atm, 999));
        assertEquals(100, acc.getBalance());


    }
}