package me.Kesims.Bank.atms;

import me.Kesims.Bank.card.BaseCard;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class ATMStorageService {

    private ArrayList<BaseATM> ATMs = new ArrayList<>();

    public void addATM(BaseATM atm) {
        ATMs.add(atm);
    }

    public List<BaseATM> getATMs() {
        return (List<BaseATM>) this.ATMs.clone();
    }

    public BaseATM findATM(String identificator) {
        for(BaseATM atm : ATMs) {
            if(atm.getIdentificator().equals(identificator)) {
                return atm;
            }
        }
        return null;
    }
}
