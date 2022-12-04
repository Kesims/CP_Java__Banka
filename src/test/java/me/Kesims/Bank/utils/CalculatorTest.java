package me.Kesims.Bank.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() throws Exception {
        assertEquals(3, Calculator.add(1, 2));
        //throw new Exception("safd");
    }

    @Test
    void subtract() {
        assertEquals(2, Calculator.subtract(4, 2));
    }

    @Test
    void multiply() {
        assertEquals(3, Calculator.divide(6, 2));
    }

    @Test
    void divide() {
        assertEquals(15, Calculator.multiply(3, 5));
    }

    @Test
    void power() {
        assertEquals(0, Calculator.pow(0));
        assertEquals(4, Calculator.pow(2));
        assertEquals(9, Calculator.pow(3));
    }

}