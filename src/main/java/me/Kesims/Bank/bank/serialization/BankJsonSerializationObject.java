package me.Kesims.Bank.bank.serialization;

import me.Kesims.Bank.accounts.accountTypes.BaseAccount;
import me.Kesims.Bank.accounts.serialization.AccountJsonSerializationObject;

import java.util.ArrayList;

public class BankJsonSerializationObject {
    public ArrayList<AccountJsonSerializationObject> accountList = new ArrayList<>();
}
