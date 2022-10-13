package me.Kesims.Bank.menu;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
    public void printMenu() {
        MenuChoices.help();
    }

    public MenuChoices read() {
        try {
            System.out.print("What do you want: ");
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            int menuInput = scanner.nextInt();
            System.out.println("Your choice: " + menuInput);

            return MenuChoices.getChoiceFromInt(menuInput);
        } catch (Exception exception) {
            System.out.println("Input is not valid");

            return MenuChoices.INVALID_CHOICE;
        }
    }

    public MenuChoices simpleRead() {
        try {
            System.out.print("What do you want: ");
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            String input = scanner.next();

            //to be continued

            return MenuChoices.getChoiceFromInt(menuInput);
        } catch (Exception exception) {
            System.out.println("Input is not valid");

            return MenuChoices.INVALID_CHOICE;
        }
    }
}
