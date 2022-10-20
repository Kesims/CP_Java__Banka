package me.Kesims.Bank.ui.actions;

import me.Kesims.Bank.person.PersonFactory;
import me.Kesims.Bank.ui.cmd.ScannerService;

import javax.inject.Inject;

public class CreatePersonAction implements Action {

    @Inject
    ScannerService scanner;

    @Inject
    PersonFactory personFactory;

    @Override
    public void processAction() {
        System.out.println("--- New client -------------------------------------");
        System.out.print(" :: Client ID: ");
        int id = scanner.readInt();
        System.out.print(" :: First Name: ");
        String firstName = scanner.readString();
        System.out.print(" :: Last Name: ");
        String lastName = scanner.readString();

        personFactory.createPerson(firstName, lastName, id);

        System.out.println("--- Success! Client created. -----------------------");
    }
}


