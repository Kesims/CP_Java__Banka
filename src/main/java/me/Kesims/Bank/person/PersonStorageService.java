package me.Kesims.Bank.person;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.HashMap;

@Singleton
public class PersonStorageService {
//    ArrayList<Person> personList = new ArrayList<>();

    HashMap<Integer, Person> personMap = new HashMap<>();

    public void addPerson(Person person) {
        personMap.put(person.getId(), person);
    }

    public Person[] getPersonArray() {
        return personMap.values().toArray(new Person[0]);
    }

    public Person findPersonById(int id) {
        return personMap.get(id);
    }
}
