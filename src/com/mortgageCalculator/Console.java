package com.mortgageCalculator;

import java.text.NumberFormat;

public class Console {
    private Mortgage mortgage;


    public Console(Mortgage mortgage) {
        setMortgage(mortgage);
    }


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


    private void setMortgage(Mortgage mortgage) {
        this.mortgage = mortgage;
    }

    private Mortgage getMortgage() {
        return mortgage;
    }
}
