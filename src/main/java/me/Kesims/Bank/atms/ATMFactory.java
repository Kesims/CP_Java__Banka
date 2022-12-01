package me.Kesims.Bank.atms;

import javax.inject.Singleton;

@Singleton
public class ATMFactory {
    public BaseATM createATM(String identificator) {
        return new BaseATM(identificator);
    }
}
