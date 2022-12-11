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

    @Inject
    AtmInfoPrinterService atmInfoPrinterService;

    public void printAccountBalanceByCard(BaseATM atm) {
        BaseCard card = atm.getCard();
        if(card == null) {
            atmInfoPrinterService.printNoCardInserted();
            return;
        }
        accountInfoPrinterService.printAccountBalance(card.getAccount());
    }

    public boolean accountWithdrawMoneyByCard(BaseATM atm, float amount) {
        BaseCard card = atm.getCard();
        if(card == null) {
            atmInfoPrinterService.printNoCardInserted();
            return false;
        }
        if (card instanceof CreditCard creditCard) {
            if(creditCardMoneyTransferService.withdrawFromCreditCard(creditCard, amount)) {
                atmInfoPrinterService.printWithdrawalSuccessful();
                return true;
            }
            else {
                atmInfoPrinterService.printOverLimit();
                return false;
            }
        }
        else {
            if(card.getAccount().removeBalance(amount)) {
                atmInfoPrinterService.printWithdrawalSuccessful();
                return true;
            }
            else {
                atmInfoPrinterService.printAccountBalanceTooLow();
                return false;
            }
        }
    }
}
