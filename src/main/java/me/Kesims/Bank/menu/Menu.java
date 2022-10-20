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
            System.out.println("Invalid input!");

            return MenuChoices.INVALID_CHOICE;
        }
    }

    public String simpleRead() {
        try {
            System.out.print("What do you want: ");
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            return scanner.next();
        } catch (Exception exception) {
            System.out.println("Input is not valid");

            return "";
        }
    }
}
