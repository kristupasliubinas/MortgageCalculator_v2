package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Taking input from the user
        Scanner scanner = new Scanner(System.in);

        int principal = 0;
        while (true) {
            System.out.print("Principal (£1K - £1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        float annualInterest = 0;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }

        byte years = 0;
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }


        // Mortgage calculation
        double mortgage = calculateMortgage(principal, annualInterest, years);


        // Outputting the result to the user
        // 1. Formatting as a currency
        String formattedOutput = NumberFormat.getCurrencyInstance().format(mortgage);

        // 2. Output
        System.out.println("Mortgage: " + formattedOutput);
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
