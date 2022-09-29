package me.Kesims.Bank;

import me.Kesims.Bank.accounts.AccountFactory;
import me.Kesims.Bank.accounts.BaseAccount;
import me.Kesims.Bank.accounts.SavingsAccount;
import me.Kesims.Bank.accounts.StudentAccount;
import me.Kesims.Bank.accounts.services.AccountInfoPrinterService;
import me.Kesims.Bank.accounts.services.InterestManagerService;
import me.Kesims.Bank.accounts.services.MoneyTransferService;
import me.Kesims.Bank.actions.ActionListener;
import me.Kesims.Bank.actions.HelpAction;
import me.Kesims.Bank.card.CardCreatorService;
import me.Kesims.Bank.menu.Menu;
import me.Kesims.Bank.menu.MenuChoices;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.person.PersonFactory;

import javax.inject.Inject;
import java.util.ArrayList;

public class Bank {


    public class Bank {

        @Inject
        private ActionListener actionListener;

        @Inject
        private AccountInfoPrinterService accountInfoPrinterService;

        @Inject
        private MoneyTransferService moneyTransferService;

        @Inject
        private InterestManagerService interestManagerService;

        @Inject
        private PersonFactory personFactory;

        @Inject
        private AccountFactory accountFactory;

        @Inject
        private CardCreatorService cardCreatorService;

        @Inject
        public Bank(AccountInfoPrinterService accountInfoPrinterService) {
            this.registerActions();
        }

        public void registerActions() {
            this.actionListener.registerAction(MenuChoices.HELP, new HelpAction());
            this.actionListener.registerAction(MenuChoices.DETAIL, new HelpAction());
            this.actionListener.registerAction(MenuChoices.ACCOUNTS, new HelpAction());
            this.actionListener.registerAction(MenuChoices.CREDIT, new HelpAction());
            this.actionListener.registerAction(MenuChoices.SAVING, new HelpAction());
            this.actionListener.registerAction(MenuChoices.INVALID_CHOICE, new HelpAction());
        }

        public void startTerminal() {
            System.out.println("Hello from bank application!");

            Menu menu = new Menu();
            menu.printMenu();

            while (true) {
                MenuChoices choice = menu.read();

                if (choice == MenuChoices.EXIT) {
                    break;
                }

                this.actionListener.processAction(choice);
            }
        }

        public void example() {

            Person owner = this.personFactory.createPerson("Tomas", "Pesek");

            BaseAccount accountOne = this.accountFactory.createStudentAccount(owner, 1000);
            BaseAccount accountTwo = this.accountFactory.createBaseAccount(owner, 5000);
            BaseAccount accountThree = this.accountFactory.createSavingsAccount(owner, 10000);

            this.accountInfoPrinterService.printAccountBalance(accountOne);
            this.accountInfoPrinterService.printAccountBalance(accountTwo);
            this.accountInfoPrinterService.printAccountBalance(accountThree);
            System.out.println();

            this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);

            this.accountInfoPrinterService.printAccountBalance(accountOne);
            this.accountInfoPrinterService.printAccountBalance(accountTwo);
            System.out.println();

            ArrayList<BaseAccount> accounts = new ArrayList<>();
            accounts.add(accountOne);
            accounts.add(accountTwo);
            accounts.add(accountThree);

            interestManagerService.addInterests(accounts);

            this.accountInfoPrinterService.printAccountBalance(accountOne);
            this.accountInfoPrinterService.printAccountBalance(accountTwo);
            this.accountInfoPrinterService.printAccountBalance(accountThree);
            System.out.println();

            this.cardCreatorService.createCardAndSetIntoAccount(accountOne);
            this.accountInfoPrinterService.printAccountBalance(accountOne);
        }
    }