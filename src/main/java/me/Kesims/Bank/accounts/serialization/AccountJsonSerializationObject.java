package me.Kesims.Bank.accounts.serialization;

import me.Kesims.Bank.card.BaseCard;
import me.Kesims.Bank.card.serialization.CardJsonSerializationObject;
import me.Kesims.Bank.card.serialization.CreditCardJsonSerializationObject;
import me.Kesims.Bank.person.Person;
import me.Kesims.Bank.person.serialization.PersonJsonSerializationObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AccountJsonSerializationObject {
    public String accountType;
    public float balance;
    public PersonJsonSerializationObject owner;
    public List<CardJsonSerializationObject> cards = new ArrayList<>();
    public List<CreditCardJsonSerializationObject> creditCards = new ArrayList<>();
    public String accountNumber;
}
