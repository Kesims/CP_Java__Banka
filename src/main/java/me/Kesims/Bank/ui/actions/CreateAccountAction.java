package me.Kesims.Bank.ui.actions;

import me.Kesims.Bank.accounts.accountTypes.AccountType;
import me.Kesims.Bank.accounts.services.AccountCreationService;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.person.PersonStorageService;
import me.Kesims.Bank.ui.cmd.ScannerService;

import javax.inject.Inject;
import java.util.ArrayList;

public class CreateAccountAction implements Action {

    @Inject
    AccountCreationService accountCreationService;

    @Inject
    ScannerService scanner;

    @Inject
    PersonStorageService personStorageService;

    @Override
    public void processAction() {
        System.out.println("--- New account -------------------------------------");
        System.out.println(" :: Available account types: ");
        ArrayList<String> accountTypes = AccountType.getTypesStringList();
        for(int i = 0; i < accountTypes.size(); i++) {
            System.out.println("    [" + i + "] " + accountTypes.get(i));
        }
        System.out.print(" :: Account type: ");
        int typeSelection = scanner.readInt();
        if (typeSelection < 0 || typeSelection > AccountType.values().length-1) {
            System.out.println("--- Action failed! Invalid account type! -------");
            return;
        }
        AccountType accountType = AccountType.values()[typeSelection];
        System.out.print(" :: Owner ID: ");
        int ownerID = scanner.readInt();
        Person person = personStorageService.findPersonById(ownerID);
        if(person == null) {
            System.out.println("--- Action failed! Person does not exist! ------");
            return;
        }
        accountCreationService.createAccount(accountType, person, 0);

        System.out.println("--- Success! Account created. -----------------------");
    }
}