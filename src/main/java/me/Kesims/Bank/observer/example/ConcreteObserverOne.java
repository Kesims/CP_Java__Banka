package me.Kesims.Bank.observer.example;

import me.Kesims.Bank.observer.Observer;

public class ConcreteObserverOne implements Observer {
    @Override
    public void update() {
        System.out.println("Updating observer One.");
    }
}
