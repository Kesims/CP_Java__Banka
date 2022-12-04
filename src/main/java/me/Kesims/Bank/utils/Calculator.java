package me.Kesims.Bank.utils;

public class Calculator {

    public static double add(double a, double b ) {
        return a+b;
    }

    public static double subtract(double a, double b) {
        return a-b;
    }

    public static double multiply(double a, double b) {
        return a*b;
    }

    public static double divide(double a, double b) {
        return a/b;
    }

    static int pow(int num) {
        return (int) Math.pow(num, 2);
    }
}
