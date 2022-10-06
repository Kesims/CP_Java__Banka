package me.Kesims.Bank.person;

import me.Kesims.Bank.person.serialization.PersonJsonSerializationObject;

import javax.inject.Singleton;

@Singleton
public class PersonFactory {
    public Person createPerson(String name, String lastName) {
        return new Person(name, lastName);
    }

    public Person createFromSerializedPerson(PersonJsonSerializationObject serializedPerson) {
        return this.createPerson(serializedPerson.firstName, serializedPerson.lastName);
    }
}
