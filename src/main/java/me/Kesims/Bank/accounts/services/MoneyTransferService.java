package me.Kesims.Bank.accounts.services;

import me.Kesims.Bank.accounts.BaseAccount;

import javax.inject.Singleton;

@Singleton
public class MoneyTransferService {
    BankFeeCalculator feeCalculator;

    public MoneyTransferService() {
        this.feeCalculator = new BankFeeCalculator();
    }

    public void transferMoney(BaseAccount sender, BaseAccount recipient, float amount) {
        if(sender.removeBalance(amount)) {
            recipient.addBalance(feeCalculator.deductPaymentFee(sender, amount));
        }
        else {
            System.out.println("The sender account does not have enough money to send!");
        }
    }
}
