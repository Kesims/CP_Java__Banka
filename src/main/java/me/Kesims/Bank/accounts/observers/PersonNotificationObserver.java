package me.Kesims.Bank.accounts.observers;

import me.Kesims.Bank.observer.Observer;

public class PersonNotificationObserver implements Observer {
    @Override
    public void update(Object... arguments) {
        System.out.println("Notifying person about his account being created.");
    }
}
