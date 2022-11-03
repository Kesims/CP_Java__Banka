package me.Kesims.Bank;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.Kesims.Bank.bank.Bank;
import me.Kesims.Bank.bank.BankInjector;

import static me.Kesims.Bank.observer.example.Main.mainObs;

public class Main {

    public static void main(String[] args) {

//        Scanner s = new Scanner(new InputStreamReader(System.in));
//        System.out.println(s.next());


        mainObs();

        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        bank.startTerminal();
    }
}