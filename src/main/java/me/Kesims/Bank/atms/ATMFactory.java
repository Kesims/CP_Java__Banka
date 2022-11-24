package me.Kesims.Bank.atms;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ATMFactory {

    @Inject
    ATMStorageService atmStorageService;

    public BaseATM createATM(String identificator) {
        BaseATM atm = new BaseATM(identificator);
        atmStorageService.addATM(atm);
        return atm;
    }
}
