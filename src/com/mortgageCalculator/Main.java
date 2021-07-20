package com.mortgageCalculator;

public class Main {

    public static void main(String[] args) {

        var mortgage1 = new Mortgage();
        var report1 = new Report(mortgage1);

        report1.printMortgage();
        report1.printPaymentSchedule();
    }
}
