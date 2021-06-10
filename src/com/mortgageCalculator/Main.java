package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Taking input from the user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        double annualInterest = scanner.nextDouble();

        System.out.print("Period (Years): ");
        byte period = scanner.nextByte();


        // Mortgage calculation
        // 1. Monthly interest rate
        double monthlyInterest = annualInterest / 12 / 100;

        // 2. Number of payments
        int payments = period * 12;

        // 3. Mortgage calculation
        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, payments)) / (Math.pow(1 + monthlyInterest, payments) - 1));


        // Outputting the result to the user
        // 1. Formatting as a currency
        String formattedOutput = NumberFormat.getCurrencyInstance().format(mortgage);

        // 2. Output
        System.out.println("Mortgage: " + formattedOutput);
    }
}
