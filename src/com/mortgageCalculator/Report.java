package com.mortgageCalculator;

import java.text.NumberFormat;

public class Report {
    private Mortgage mortgage;


    public Report(Mortgage mortgage) {
        setMortgage(mortgage);
    }


    // Output methods
    public void printMortgage() {
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + formatAsCurrency(mortgage.calculateMortgage()));
    }

    public void printPaymentSchedule() {
        short numberOfPayments = mortgage.calculateNumberOfPayments();
        double remainingBalance;

        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (int paymentsMade = 1; paymentsMade <= numberOfPayments; paymentsMade++) {
            remainingBalance = mortgage.calculateRemainingBalance(paymentsMade);
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
