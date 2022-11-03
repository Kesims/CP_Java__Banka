package me.Kesims.Bank.accounts.observers;

import me.Kesims.Bank.observer.Observer;

public class CeoNotificationObserver implements Observer {
    @Override
    public void update() {
        System.out.println("Notifying CEO, new account was created!");
    }
}
