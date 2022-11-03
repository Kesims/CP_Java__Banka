package me.Kesims.Bank.observer.example;

import me.Kesims.Bank.observer.Observer;
import me.Kesims.Bank.observer.Subject;

public class Main {
    public static void mainObs() {
        Observer o1 = new ConcreteObserverOne();
        Observer o2 = new ConcreteObserverTwo();

        Subject s = new ConcreteSubject();
        s.addObserver(o1);
        s.addObserver(o2);
        s.notifyObservers();
    }
}
