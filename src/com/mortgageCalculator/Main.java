package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // Taking input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();


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
