package me.Kesims.Bank.accounts.serialization;

import com.google.gson.Gson;
import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.card.serialization.CardJsonSerializationObjectFactory;
import me.Kesims.Bank.person.serialization.PersonJsonSerializationObjectFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountJsonSerializationObjectFactory {

    @Inject
    private PersonJsonSerializationObjectFactory personJsonSerializationObjectFactory;

    @Inject
    CardJsonSerializationObjectFactory cardJsonSerializationObjectFactory;

    public AccountJsonSerializationObject createFromBaseAccount(BaseAccount account) {
        AccountJsonSerializationObject a = new AccountJsonSerializationObject();
        a.accountNumber = account.getAccountNumber();
        a.balance = account.getBalance();
        a.owner = personJsonSerializationObjectFactory.createFromPerson(account.getOwner());
        a.accountType = account.getClass().getSimpleName();
        a.cards = cardJsonSerializationObjectFactory.createListFromCardList(account.getAccountCards());

        return a;
    }

}
