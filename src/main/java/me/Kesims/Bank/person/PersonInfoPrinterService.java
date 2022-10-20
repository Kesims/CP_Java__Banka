package me.Kesims.Bank.person;

public class PersonInfoPrinterService {
    public void printPersonInfo(Person person) {
        System.out.println("Client " + person.getFullName() + ", ID: " + person.getId() + ".");
    }
}
