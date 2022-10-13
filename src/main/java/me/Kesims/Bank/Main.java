package me.Kesims.Bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.Kesims.Bank.bank.Bank;
import me.Kesims.Bank.bank.BankCreationService;
import me.Kesims.Bank.bank.BankInjector;

import javax.inject.Inject;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        bank.example();
    }
}