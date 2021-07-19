package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Taking input from the user
        int principal = (int) readNumber("Principal (£1K - £1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        var mortgage = new Mortgage(principal, annualInterest, years);

        printMortgage(mortgage);
        printPaymentSchedule(mortgage);
    }

    public static void printMortgage(Mortgage mortgage) {
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + formatAsCurrency(mortgage.calculateMortgage()));
    }

    public static void printPaymentSchedule(Mortgage mortgage) {
        float monthlyInterest = mortgage.calculateMonthlyInterest();
        short numberOfPayments = mortgage.calculateNumberOfPayments();
        double remainingBalance;

        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (int paymentsMade = 1; paymentsMade <= numberOfPayments; paymentsMade++) {
            remainingBalance = mortgage.getPrincipal() * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), paymentsMade)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
            System.out.println(formatAsCurrency(remainingBalance));
        }
    }

    public static String formatAsCurrency(double input) {
        String formattedOutput = NumberFormat.getCurrencyInstance().format(input);
        return formattedOutput;
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

}
