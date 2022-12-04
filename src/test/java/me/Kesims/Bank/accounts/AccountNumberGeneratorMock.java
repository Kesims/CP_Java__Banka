package me.Kesims.Bank.accounts;

import com.google.inject.Singleton;

@Singleton
public class AccountNumberGeneratorMock extends AccountNumberGenerator {
    @Override
    public String getRandomAccountNumber() {
        return "01234567";
    }
}
