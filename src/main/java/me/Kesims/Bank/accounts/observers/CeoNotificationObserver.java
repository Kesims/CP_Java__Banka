package me.Kesims.Bank.accounts.observers;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.observer.Observer;

public class CeoNotificationObserver implements Observer {
    @Override
    public void update(Object... arguments) {
        System.out.println("Notifying CEO, new account was created!");
        if(arguments.length == 1 && arguments[0] instanceof BaseAccount a) {
            System.out.println("Informed CEO about account " + a.getAccountNumber() + ".");
        }
    }
}
