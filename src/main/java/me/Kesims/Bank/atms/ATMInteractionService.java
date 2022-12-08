package me.Kesims.Bank.atms;

import me.Kesims.Bank.accounts.services.AccountInfoPrinterService;
import me.Kesims.Bank.atms.BaseATM;
import me.Kesims.Bank.card.BaseCard;
import me.Kesims.Bank.card.CreditCard;
import me.Kesims.Bank.card.CreditCardMoneyTransferService;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ATMInteractionService {
    @Inject
    AccountInfoPrinterService accountInfoPrinterService;

    @Inject
    CreditCardMoneyTransferService creditCardMoneyTransferService;

    public void printAccountBalanceByCard(BaseATM atm) {
        BaseCard card = atm.getCard();
        if(card == null) {
            System.out.println("No card inserted in the ATM");
            return;
        }
        accountInfoPrinterService.printAccountBalance(card.getAccount());
    }

    public void accountWithdrawMoneyByCard(BaseATM atm, float amount) {
        BaseCard card = atm.getCard();
        if(card == null) {
            System.out.println("No card inserted in the ATM");
            return;
        }
        if (card instanceof CreditCard creditCard) {
            if(creditCardMoneyTransferService.withdrawFromCreditCard(creditCard, amount)) {
                System.out.println("Money successfully withdrew from the machine!");
            }
            else {
                System.out.println("The required amount is above your limit.");
            }
        }
        else {
            if(card.getAccount().removeBalance(amount)) {
                System.out.println("Money successfully withdrew from the machine!");
            }
            else {
                System.out.println("Balance too low for withdrawal!");
            }
        }
    }
}
