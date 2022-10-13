package me.Kesims.Bank.person;

import me.Kesims.Bank.person.serialization.PersonJsonSerializationObject;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PersonFactory {

    @Inject
    PersonStorageService personStorageService;

    public Person createPerson(String name, String lastName, int id) {
        Person p = new Person(name, lastName, id);
        personStorageService.addPerson(p);
        return p;
    }

    public Person createFromSerializedPerson(PersonJsonSerializationObject serializedPerson) {
        Person tryFind = personStorageService.findPersonById(serializedPerson.id);
        if(tryFind != null) {
            return tryFind;
        }
        return this.createPerson(serializedPerson.firstName, serializedPerson.lastName, serializedPerson.id);
    }
}
