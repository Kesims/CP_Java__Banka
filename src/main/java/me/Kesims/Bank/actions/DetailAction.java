package me.Kesims.Bank.actions;

import me.Kesims.Bank.accounts.AccountStorageService;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.services.AccountInfoPrinterService;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.person.PersonInfoPrinterService;
import me.Kesims.Bank.person.PersonStorageService;

import javax.inject.Inject;

public class DetailAction implements Action {

    @Inject
    AccountStorageService accountStorageService;

    @Inject
    AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    PersonStorageService personStorageService;

    @Inject
    PersonInfoPrinterService personInfoPrinterService;

    @Override
    public void processAction() {
        System.out.println("--- Loaded Persons --------------------------------");
        for(Person per : personStorageService.getPersonArray()) {
            personInfoPrinterService.printPersonInfo(per);
        }

        System.out.println("--- Loaded Accounts -------------------------------");
        for (BaseAccount acc : accountStorageService.getAccounts()) {
            accountInfoPrinterService.printAccountBalance(acc);
        }

        System.out.println("---------------------------------------------------");
    }
}
