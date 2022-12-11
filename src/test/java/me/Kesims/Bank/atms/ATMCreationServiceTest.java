package me.Kesims.Bank.atms;

import com.google.inject.Guice;
import com.google.inject.Inject;
import me.Kesims.Bank.bank.BankInjectorTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMCreationServiceTest {

    @Inject
    ATMCreationService atmCreationService;

    @Inject
    ATMStorageService atmStorageService;

    @BeforeEach
    void setUp() {
        Guice.createInjector(new BankInjectorTest()).injectMembers(this);
    }

    @Test
    void createATM() {
        BaseATM a = atmCreationService.createATM("123");
        assertEquals("123", a.getIdentificator());
        assertNull(a.getCard());
        assertEquals(a, atmStorageService.getATMs().get(0));
        assertEquals(a, atmStorageService.findATM("123"));
    }
}