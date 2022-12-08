package me.Kesims.Bank.ui.actions;

import me.Kesims.Bank.accounts.accountTypes.AccountType;
import me.Kesims.Bank.atms.ATMFactory;
import me.Kesims.Bank.atms.ATMInteractionService;
import me.Kesims.Bank.atms.ATMStorageService;
import me.Kesims.Bank.atms.BaseATM;
import me.Kesims.Bank.card.CardStorageService;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.ui.cmd.ScannerService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Scanner;

public class AtmWithdrawAction implements Action {

    @Inject
    ScannerService scanner;

    @Inject
    ATMInteractionService atmInteractionService;

    @Inject
    ATMFactory atmFactory;

    @Inject
    CardStorageService cardStorageService;

    @Override
    public void processAction() {
        BaseATM baseATM = atmFactory.createATM("lol");

        System.out.println("--- ATM Withdrawal ---------------------------------");
        System.out.println(" :: Enter your card number: ");
        String cardNumber = scanner.readString();
        System.out.print(" :: Enter amount you would like to withdraw: ");
        float amount = scanner.readFloat();
        try {
            baseATM.injectCard(cardStorageService.findCard(cardNumber));
        }
        catch (Exception e) {
            System.out.println("--- Could not inject card into ATM! ------------");
            return;
        }
        atmInteractionService.accountWithdrawMoneyByCard(baseATM, amount);
    }
}
