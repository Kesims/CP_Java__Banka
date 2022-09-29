package me.Kesims.Bank.person;

public class PersonFactory {
    public Person createPerson(String name, String lastName) {
        return new Person(name, lastName);
    }
}
