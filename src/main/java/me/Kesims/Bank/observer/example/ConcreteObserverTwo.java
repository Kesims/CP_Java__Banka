package me.Kesims.Bank.observer.example;

import me.Kesims.Bank.observer.Observer;

public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Object... arguments) {
        System.out.println("Updating observer Two.");
    }
}
