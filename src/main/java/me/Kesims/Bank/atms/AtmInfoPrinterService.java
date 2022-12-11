package me.Kesims.Bank.atms;

import com.google.inject.Singleton;

@Singleton
public class AtmInfoPrinterService {
    public void printNoCardInserted() {
        System.out.println("-- No card inserted in the ATM!");
    }

    public void printWithdrawalSuccessful() {
        System.out.println("-- Money successfully withdrawn from the ATM!");
    }

    public void printOverLimit() {
        System.out.println("-- The required amount is over your CC limit.");
    }

    public void printAccountBalanceTooLow() {
        System.out.println("-- Balance too low for withdrawal!");
    }
}
