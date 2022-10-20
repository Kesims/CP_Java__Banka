package me.Kesims.Bank.bank;

import me.Kesims.Bank.actions.ActionProcessService;
import me.Kesims.Bank.bank.serialization.BankJsonSerializationObjectFactory;
import me.Kesims.Bank.accounts.accountTypes.AccountType;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObjectFactory;
import me.Kesims.Bank.accounts.services.AccountCreationService;
import me.Kesims.Bank.accounts.services.AccountInfoPrinterService;
import me.Kesims.Bank.accounts.services.InterestManagerService;
import me.Kesims.Bank.accounts.services.MoneyTransferService;
import me.Kesims.Bank.actions.HelpAction;
import me.Kesims.Bank.card.CardCreatorService;
import me.Kesims.Bank.card.CardInfoPrinterService;
import me.Kesims.Bank.menu.Menu;
import me.Kesims.Bank.menu.MenuChoices;
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

    public void startTerminal() {
        System.out.println("Hello from bank application!");

        Menu menu = new Menu();
        menu.printMenu();

        while (true) {
            MenuChoices choice = menu.read();

            if (choice == MenuChoices.EXIT) {
                break;
            }

            actionProcessService.processAction(choice);
        }
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


        interestManagerService.addInterests();

        this.accountInfoPrinterService.printAccountBalance(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountTwo);
        this.accountInfoPrinterService.printAccountBalance(accountThree);
        System.out.println();

        this.cardCreatorService.createCardAndSetIntoAccount(accountOne);
        this.accountInfoPrinterService.printAccountBalance(accountOne);

        this.cardInfoPrinterService.printAccountCards(accountOne);




        String json = gsonSerializationService.serialize(bankJsonSerializationObjectFactory.createFromBank());
        System.out.println(json);

        storage.save(json, "bank.json");

        String jsonFile = storage.load("accounts.json");
        AccountJsonSerializationObject deserializedAccount = gsonSerializationService.deserialize(jsonFile, AccountJsonSerializationObject.class);
        System.out.println(deserializedAccount.accountNumber);
        BaseAccount deserializedBase = accountCreationService.createAccount(deserializedAccount);
    }
}