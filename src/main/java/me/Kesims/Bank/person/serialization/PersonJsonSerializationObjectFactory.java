package me.Kesims.Bank.person.serialization;

import me.Kesims.Bank.person.Person;

import javax.inject.Singleton;

@Singleton
public class PersonJsonSerializationObjectFactory {
    public PersonJsonSerializationObject createFromPerson(Person person) {
        PersonJsonSerializationObject p = new PersonJsonSerializationObject();
        p.firstName = person.getFirstName();
        p.lastName = person.getLastName();

        return p;
    }
}
