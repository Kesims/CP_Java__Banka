package me.Kesims.Bank.accounts.observers;

import me.Kesims.Bank.observer.Observer;
import me.Kesims.Bank.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class EmailNotificationSubject implements Subject {

    public List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers(Object... arguments) {
        for(Observer o : observers) {
            o.update(arguments);
        }
    }
}
