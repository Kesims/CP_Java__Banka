package me.Kesims.Bank.ui.menu;

import me.Kesims.Bank.ui.cmd.ScannerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.InputStreamReader;
import java.util.Scanner;

@Singleton
public class Menu {

    @Inject
    ScannerService scanner;

    public void printMenu() {
        MenuChoices.help();
    }

    public MenuChoices read() {
        try {
            System.out.print("What do you want: ");
            int menuInput = scanner.readInt();
            System.out.println("Your choice: " + menuInput);

            return MenuChoices.getChoiceFromInt(menuInput);
        } catch (Exception exception) {
            System.out.println("Invalid input!");

            return MenuChoices.INVALID_CHOICE;
        }
    }

    public String simpleRead() {
        try {
            System.out.print("What do you want: ");
            return scanner.readString();
        } catch (Exception exception) {
            System.out.println("Input is not valid");

            return "";
        }
    }
}
