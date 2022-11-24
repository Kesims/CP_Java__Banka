package me.Kesims.Bank.atms;

import me.Kesims.Bank.card.BaseCard;

public class BaseATM {

    private String identificator;
    private BaseCard card;

    public BaseATM(String identificator) {
        setIdentificator(identificator);
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public String getIdentificator() {
        return identificator;
    }

    public void injectCard(BaseCard card) throws Exception {
        if (this.card == null) {
            this.card = card;
        }
        else {
            throw new Exception("another card already there.");
        }
    }

    public BaseCard ejectCard() throws Exception {
        if(this.card == null) {
            throw new Exception("No card in the ATM");
        }
        else {
            BaseCard card1 = this.card;
            this.card = null;
            return card1;
        }
    }

    public BaseCard getCard() {
        return card;
    }
}
