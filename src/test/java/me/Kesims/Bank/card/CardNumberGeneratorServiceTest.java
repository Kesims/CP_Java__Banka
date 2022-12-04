package me.Kesims.Bank.card;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CardNumberGeneratorServiceTest {

    CardNumberGeneratorService cardNumberGeneratorService = new CardNumberGeneratorService();

    @Test
    void generateCardNumber() {
        assertEquals(16, cardNumberGeneratorService.generateCardNumber().length());
    }

    @Test
    void generateExpiration() {
        String cardExpiration = cardNumberGeneratorService.generateExpiration();
        assertEquals(5, cardExpiration.length());
        assertEquals('/', cardExpiration.charAt(2));

        //Date date = new Date();
        //date.setMonth(Integer.parseInt(cardExpiration.split("/")[0]));
        //date.setYear(Integer.parseInt(cardExpiration.split("/")[1]));

        //assertTrue(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isAfter(LocalDateTime.now().toLocalDate()));
    }

    @Test
    void generateCvc() {
        assertEquals(3, cardNumberGeneratorService.generateCvc().length());
    }
}