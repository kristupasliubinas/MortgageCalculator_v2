package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Taking input from the user
        int principal = (int) readNumber("Principal (£1K - £1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        // Mortgage calculation
        double mortgage = calculateMortgage(principal, annualInterest, years);

        // Outputting the result to the user
        // 1. Formatting as a currency
        String formattedOutput = NumberFormat.getCurrencyInstance().format(mortgage);
        // 2. Output
        System.out.println("Mortgage: " + formattedOutput);
    }

    public static double readNumber(String prompt, double lowerLimit, double upperLimit) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= lowerLimit && value <= upperLimit)
                break;
            System.out.println("Enter a value between " + lowerLimit + " and " + upperLimit);
        }
        return value;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);

        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        return mortgage;
    }
}
