package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // Taking input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal (£1K - £1M): ");
        int principal = scanner.nextInt();
        while (!(principal >= 1000 && principal <= 1_000_000)) {
            System.out.println("Enter a number between 1,000 and 1,000,000.");
            System.out.print("Principal (£1K - £1M): ");
            principal = scanner.nextInt();
        }

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        while (!(annualInterest > 0 && annualInterest <= 30)) {
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
        }

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        while (!(years >= 1 && years <= 30)) {
            System.out.println("Enter a value between 1 and 30.");
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
        }


        // Mortgage calculation
        // 1. Monthly interest rate
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;

        // 2. Number of payments
        int numberOfPayments = years * MONTHS_IN_YEAR;

        // 3. Mortgage calculation
        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));


        // Outputting the result to the user
        // 1. Formatting as a currency
        String formattedOutput = NumberFormat.getCurrencyInstance().format(mortgage);

        // 2. Output
        System.out.println("Mortgage: " + formattedOutput);
    }
}
