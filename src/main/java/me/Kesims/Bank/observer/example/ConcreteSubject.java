package me.Kesims.Bank.observer.example;

import me.Kesims.Bank.observer.Observer;
import me.Kesims.Bank.observer.Subject;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

    List<Observer> observers = new ArrayList<Observer>();

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
            o.update();
        }
    }
}
