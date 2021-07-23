package com.mortgageCalculator;

import java.text.NumberFormat;

public class Report {
    // This class is responsible only for PRESENTATION concerns
    private Mortgage mortgage;
    private final NumberFormat currencyFormat;


    public Report(Mortgage mortgage) {
        setMortgage(mortgage);
        currencyFormat = NumberFormat.getCurrencyInstance();
    }


    // Output methods
    public void printMortgage() {
        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + currencyFormat.format(mortgage.calculateMortgage()));
    }

    public void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        double[] paymentSchedule = mortgage.calculatePaymentSchedule();
        for (double payment : paymentSchedule)
            System.out.println(currencyFormat.format(payment));
    }


    // Getters and Setters
    private void setMortgage(Mortgage mortgage) {
        this.mortgage = mortgage;
    }
}
