package me.Kesims.Bank.accounts;

import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class AccountNumberGeneratorTest {

    AccountNumberGenerator accountNumberGenerator = new AccountNumberGenerator();

    @Test
    void getRandomAccountNumber() {
        String accountNumber = accountNumberGenerator.getRandomAccountNumber();
        assertEquals(8, accountNumber.length());
        assertTrue(Integer.parseInt(accountNumber) > 0);
        assertTrue(true);
        assertFalse(false);
    }
}