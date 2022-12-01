package me.Kesims.Bank.atms;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ATMCreationService {

    @Inject
    ATMStorageService atmStorageService;

    @Inject
    ATMFactory atmFactory;

    public BaseATM createATM(String identificator) {
        BaseATM atm = atmFactory.createATM(identificator);
        atmStorageService.addATM(atm);
        return atm;
    }
}
