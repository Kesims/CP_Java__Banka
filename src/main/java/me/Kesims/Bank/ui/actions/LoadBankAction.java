package me.Kesims.Bank.ui.actions;

import me.Kesims.Bank.bank.BankCreationService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoadBankAction implements Action {

    @Inject
    BankCreationService bankCreationService;

    @Override
    public void processAction() {
        bankCreationService.createFromFileStorage();
        System.out.println(" -- Bank Loaded!");
    }
}
