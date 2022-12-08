package me.Kesims.Bank.bank;

import me.Kesims.Bank.atms.ATMCreationService;
import me.Kesims.Bank.atms.ATMInteractionService;
import me.Kesims.Bank.atms.ATMStorageService;
import me.Kesims.Bank.atms.BaseATM;
import me.Kesims.Bank.card.*;
import me.Kesims.Bank.cron.QuartzScheduler;
import me.Kesims.Bank.ui.actions.ActionProcessService;
import me.Kesims.Bank.bank.serialization.BankJsonSerializationObjectFactory;
import me.Kesims.Bank.accounts.accountTypes.AccountType;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObjectFactory;
import me.Kesims.Bank.accounts.services.AccountCreationService;
import me.Kesims.Bank.accounts.services.AccountInfoPrinterService;
import me.Kesims.Bank.accounts.services.InterestManagerService;
import me.Kesims.Bank.accounts.services.MoneyTransferService;
import me.Kesims.Bank.ui.menu.Menu;
import me.Kesims.Bank.ui.menu.MenuChoices;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.person.PersonFactory;
import me.Kesims.Bank.storage.GsonSerializationService;
import me.Kesims.Bank.storage.IOFileStorageService;

import javax.inject.Inject;

public class Bank {
    @Inject
    private AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    private MoneyTransferService moneyTransferService;

    @Inject
    private InterestManagerService interestManagerService;

    @Inject
    private PersonFactory personFactory;

    @Inject
    private AccountCreationService accountCreationService;

    @Inject
    private CardCreatorService cardCreatorService;

    @Inject
    private CardInfoPrinterService cardInfoPrinterService;

    @Inject
    public Bank(AccountInfoPrinterService accountInfoPrinterService) {
//        this.registerActions();
    }

    @Inject
    BankJsonSerializationObjectFactory bankJsonSerializationObjectFactory;

    @Inject
    private IOFileStorageService storage;

    @Inject
    private AccountJsonSerializationObjectFactory accountJsonSerializationObjectFactory;

    @Inject
    private GsonSerializationService gsonSerializationService;

    @Inject
    ActionProcessService actionProcessService;

    @Inject
    Menu menu;

    @Inject
    QuartzScheduler quartzScheduler;

    @Inject
    CardStorageService cardStorageService;

    @Inject
    ATMCreationService atmFactory;

    @Inject
    ATMStorageService atmStorageService;

    @Inject
    ATMInteractionService baseATMMenu;

    public void startTerminal() {
        quartzScheduler.registerJobs();
        menu.printMenu();

        while (true) {
            MenuChoices choice = menu.read();
            if (choice == MenuChoices.EXIT) {
                break;
            }
            actionProcessService.processAction(choice);
        }
        quartzScheduler.shutdownScheduler();
    }

    public void example() {

        Person owner = this.personFactory.createPerson("Matej", "Neumann", 1);

        BaseAccount accountOne = this.accountCreationService.createAccount(AccountType.StudentAccount, owner, 1000);
        BaseAccount accountTwo = this.accountCreationService.createAccount(AccountType.BaseAccount, owner, 1000);
        BaseAccount accountThree = this.accountCreationService.createAccount(AccountType.SavingsAccount, owner, 1000);


        this.accountInfoPrinterService.printAccountBalance(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountTwo);
        this.accountInfoPrinterService.printAccountBalance(accountThree);
        System.out.println();

        this.moneyTransferService.transferMoney(accountOne, accountTwo, 500);

        this.accountInfoPrinterService.printAccountBalance(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountTwo);
        System.out.println();



        this.accountInfoPrinterService.printAccountBalance(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountTwo);
        this.accountInfoPrinterService.printAccountBalance(accountThree);
        System.out.println();

        BaseCard card1 = this.cardCreatorService.createCardAndSetIntoAccount(CardType.BaseCard, accountOne);


        BaseATM bankomat1 = this.atmFactory.createATM("Bankomat1");
        try {
            bankomat1.injectCard(card1);
        } catch(Exception ignored) {}
        baseATMMenu.printAccountBalanceByCard(bankomat1);
        baseATMMenu.accountWithdrawMoneyByCard(bankomat1, 10);
        baseATMMenu.accountWithdrawMoneyByCard(bankomat1, 10000);
        try {
            bankomat1.ejectCard();
        } catch(Exception ignored) {}
    }
}