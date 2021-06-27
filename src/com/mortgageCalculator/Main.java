package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Taking input from the user
        int principal = (int) readNumber("Principal (£1K - £1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    public static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);

        System.out.println("\nMORTGAGE\n--------");
        System.out.println("Monthly Payments: " + formatAsCurrency(mortgage));
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        float monthlyInterest = calculateMonthlyInterest(annualInterest);
        short numberOfPayments = calculateNumberOfPayments(years);
        double remainingBalance;

        System.out.println("\nPAYMENT SCHEDULE\n----------------");
        for (int paymentsMade = 1; paymentsMade <= numberOfPayments; paymentsMade++) {
            remainingBalance = principal * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), paymentsMade)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
            System.out.println(formatAsCurrency(remainingBalance));
        }
    }

    public static String formatAsCurrency(double input) {
        String formattedOutput = NumberFormat.getCurrencyInstance().format(input);
        return formattedOutput;
    }

    public static float calculateMonthlyInterest(float annualInterest) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        return monthlyInterest;
    }

    public static short calculateNumberOfPayments(byte years) {
        final byte MONTHS_IN_YEAR = 12;

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        return numberOfPayments;
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

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        float monthlyInterest = calculateMonthlyInterest(annualInterest);
        short numberOfPayments = calculateNumberOfPayments(years);

        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        return mortgage;
    }
}
