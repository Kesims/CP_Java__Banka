package me.Kesims.Bank.accounts.services;

import com.google.common.eventbus.EventBus;
import me.Kesims.Bank.accounts.AccountFactory;
import me.Kesims.Bank.accounts.AccountNumberGenerator;
import me.Kesims.Bank.accounts.AccountStorageService;
import me.Kesims.Bank.accounts.accountTypes.AccountType;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.observers.CeoNotificationObserver;
import me.Kesims.Bank.accounts.observers.EmailNotificationSubject;
import me.Kesims.Bank.accounts.observers.PersonNotificationObserver;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.Kesims.Bank.card.CardCreatorService;
import me.Kesims.Bank.events.NotificationData;
import me.Kesims.Bank.events.NotifyCustomerEvent;
import me.Kesims.Bank.observer.Observer;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.person.PersonFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountCreationService {

    @Inject
    AccountNumberGenerator accountNumberGenerator;

    @Inject
    AccountFactory accountFactory;

    @Inject
    AccountStorageService accountStorageService;

    @Inject
    PersonFactory personFactory;

    @Inject
    CardCreatorService cardCreatorService;


    EmailNotificationSubject emailNotificationSubject = new EmailNotificationSubject();

    @Inject
    EventBus eventBus;


    public BaseAccount createAccount(AccountType type, Person person, float balance) {
        String accountNum = accountNumberGenerator.getRandomAccountNumber();

        BaseAccount account = switch(type) {
            case BaseAccount -> this.accountFactory.createBaseAccount(accountNum, person, balance);
            case SavingsAccount -> this.accountFactory.createSavingsAccount(accountNum, person, balance);
            case StudentAccount -> this.accountFactory.createStudentAccount(accountNum, person, balance);
        };

        accountStorageService.addAccount(account);

        Observer ceoObserver = new CeoNotificationObserver();
        Observer personObserver = new PersonNotificationObserver();

        emailNotificationSubject.addObserver(ceoObserver);
        emailNotificationSubject.addObserver(personObserver);
        emailNotificationSubject.notifyObservers(account);
        emailNotificationSubject.removeObserver(ceoObserver);
        emailNotificationSubject.removeObserver(personObserver);

        eventBus.post(new NotifyCustomerEvent(new NotificationData(person.getFullName())));

        return account;
    }

    public BaseAccount createAccount(AccountJsonSerializationObject serializedAccount) {
        String accountNum = serializedAccount.accountNumber;

        BaseAccount account = switch(AccountType.getAccountTypeFromClassname(serializedAccount.accountType)) {
            case BaseAccount -> this.accountFactory.createBaseAccount(accountNum, personFactory.createFromSerializedPerson(serializedAccount.owner), serializedAccount.balance);
            case SavingsAccount -> this.accountFactory.createSavingsAccount(accountNum, personFactory.createFromSerializedPerson(serializedAccount.owner), serializedAccount.balance);
            case StudentAccount -> this.accountFactory.createStudentAccount(accountNum, personFactory.createFromSerializedPerson(serializedAccount.owner), serializedAccount.balance);
        };

        accountStorageService.addAccount(account);

        cardCreatorService.deserializeCardListAndSetIntoAccount(serializedAccount.cards, account);

        return account;
    }
}
