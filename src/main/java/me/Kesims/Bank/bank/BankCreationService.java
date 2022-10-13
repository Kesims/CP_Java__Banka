package me.Kesims.Bank.bank;

import me.Kesims.Bank.bank.serialization.BankJsonSerializationObject;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.Kesims.Bank.accounts.services.AccountCreationService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankCreationService {

    @Inject
    AccountCreationService accountCreationService;

    public void createFromSerializedBankJsonObject(BankJsonSerializationObject b){
        for(AccountJsonSerializationObject a : b.accountList) {
            accountCreationService.createAccount(a);
        }
    }
}
