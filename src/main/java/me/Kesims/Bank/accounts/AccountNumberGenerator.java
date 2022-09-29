package me.Kesims.Bank.accounts;

import javax.inject.Singleton;
import java.util.Random;

@Singleton
public class AccountNumberGenerator {
    Random generator = new Random();

    public String getRandomAccountNumber() {
        int randomNum = this.generator.nextInt(99999999);
        return String.format("%08d", randomNum);
    }
}
