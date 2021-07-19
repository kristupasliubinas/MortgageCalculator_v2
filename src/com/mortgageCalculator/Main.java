package com.mortgageCalculator;

public class Main {

    public static void main(String[] args) {

        var mortgage1 = new Mortgage();
        var console1 = new Console(mortgage1);

        console1.printMortgage();
        console1.printPaymentSchedule();
    }
}
