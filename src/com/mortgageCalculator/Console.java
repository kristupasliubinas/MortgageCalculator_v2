package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Console {
    private Mortgage mortgage;


    public Console(Mortgage mortgage) {
        setMortgage(mortgage);
    }


    // Input methods
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

    // Output methods
    public void printMortgage() {
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + formatAsCurrency(mortgage.calculateMortgage()));
    }

    public void printPaymentSchedule() {
        float monthlyInterest = mortgage.calculateMonthlyInterest();
        short numberOfPayments = mortgage.calculateNumberOfPayments();
        double remainingBalance;

        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (int paymentsMade = 1; paymentsMade <= numberOfPayments; paymentsMade++) {
            remainingBalance = mortgage.getPrincipal() * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), paymentsMade)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
            System.out.println(formatAsCurrency(remainingBalance));
        }
    }

    private String formatAsCurrency(double input) {
        return NumberFormat.getCurrencyInstance().format(input);
    }

    // Getters and Setters
    private void setMortgage(Mortgage mortgage) {
        this.mortgage = mortgage;
    }

    private Mortgage getMortgage() {
        return mortgage;
    }
}
