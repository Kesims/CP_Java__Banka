package me.Kesims.Bank.accounts.services;

import com.google.inject.Guice;
import com.google.inject.Inject;
import me.Kesims.Bank.accounts.AccountNumberGeneratorMock;
import me.Kesims.Bank.accounts.AccountStorageService;
import me.Kesims.Bank.accounts.accountTypes.AccountType;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.accountTypes.SavingsAccount;
import me.Kesims.Bank.accounts.accountTypes.StudentAccount;
import me.Kesims.Bank.bank.BankInjectorTest;
import me.Kesims.Bank.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountCreationServiceTest {

    @Inject
    AccountCreationService accountCreationService;

    @Inject
    AccountStorageService accountStorageService;

    @BeforeEach
    void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void testInjectBaseService() {
        assertNotNull(accountCreationService);
        assertInstanceOf(AccountCreationService.class, this.accountCreationService);
    }

    @Test
    void createAccount() {
        Person p = new Person("A", "B", 1);
        BaseAccount a = accountCreationService.createAccount(AccountType.SavingsAccount, p, 0);
        assertEquals(accountStorageService.findAccount(a.getAccountNumber()), a);
        assertSame(accountStorageService.findAccount(a.getAccountNumber()).getOwner(), p);
        assertTrue(accountStorageService.findAccount(a.getAccountNumber()) instanceof SavingsAccount);

        BaseAccount b = accountCreationService.createAccount(AccountType.StudentAccount, p, 0);
        assertEquals(accountStorageService.findAccount(b.getAccountNumber()), b);
        assertTrue(accountStorageService.findAccount(b.getAccountNumber()) instanceof StudentAccount);

        assertEquals(2, accountStorageService.getAccounts().size());

        assertNotEquals(a.getAccountNumber(), b.getAccountNumber());

        assertNull(accountStorageService.findAccount("not an existing account"));
    }
}