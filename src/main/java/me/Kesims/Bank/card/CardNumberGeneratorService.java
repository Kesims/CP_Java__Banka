package me.Kesims.Bank.card;

import javax.inject.Singleton;
import java.util.Calendar;
import java.util.Random;

@Singleton
public class CardNumberGeneratorService {

    int cardValidityTimeYears = 5;
    Random generator = new Random();

    public String generateCardNumber() {
        StringBuilder cardNumBuilder = new StringBuilder();

        for(int i = 0; i < 16; i++) {
            int num = generator.nextInt(9);
            cardNumBuilder.append(num);
        }

        return cardNumBuilder.toString();
    }

    public String generateExpiration() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR) + cardValidityTimeYears;
        int month = c.get(Calendar.MONTH);

        return String.format("%02d", month) + "/" + String.valueOf(year);
    }

    public String generateCvc() {
        return String.format("%03d", generator.nextInt(999));
    }
}
