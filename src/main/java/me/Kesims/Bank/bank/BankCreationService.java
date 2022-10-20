package me.Kesims.Bank.bank;

import com.google.errorprone.annotations.IncompatibleModifiers;
import me.Kesims.Bank.bank.serialization.BankJsonSerializationObject;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObject;
import me.Kesims.Bank.accounts.services.AccountCreationService;
import me.Kesims.Bank.storage.GsonSerializationService;
import me.Kesims.Bank.storage.IOFileStorageService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BankCreationService {

    @Inject
    AccountCreationService accountCreationService;
    @Inject
    IOFileStorageService ioFileStorageService;

    @Inject
    GsonSerializationService gsonSerializationService;

    public void createFromSerializedBankJsonObject(BankJsonSerializationObject b){
        for(AccountJsonSerializationObject a : b.accountList) {
            accountCreationService.createAccount(a);
        }
    }

    public void createFromFileStorage() {
        String jsonFile = ioFileStorageService.load("bank.json");
        BankJsonSerializationObject serializedBank = gsonSerializationService.deserialize(jsonFile, BankJsonSerializationObject.class);
        createFromSerializedBankJsonObject(serializedBank);
    }
}
