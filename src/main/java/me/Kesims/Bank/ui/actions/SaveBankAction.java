package me.Kesims.Bank.ui.actions;


import me.Kesims.Bank.bank.serialization.BankJsonSerializationObjectFactory;
import me.Kesims.Bank.storage.GsonSerializationService;
import me.Kesims.Bank.storage.IOFileStorageService;

import javax.inject.Inject;

public class SaveBankAction implements Action {
    @Inject
    GsonSerializationService gsonSerializationService;

    @Inject
    IOFileStorageService ioFileStorageService;

    @Inject
    BankJsonSerializationObjectFactory bankJsonSerializationObjectFactory;


    @Override
    public void processAction() {
        String json = gsonSerializationService.serialize(bankJsonSerializationObjectFactory.createFromBank());
        ioFileStorageService.save(json, "bank.json");
        System.out.println(" -- Bank Saved!");
    }
}
