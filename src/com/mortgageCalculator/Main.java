package com.mortgageCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Taking input from the user
        int principal = (int) readNumber("Principal (£1K - £1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        var mortgage1 = new Mortgage(principal, annualInterest, years);
        var console1 = new Console(mortgage1);

        console1.printMortgage();
        console1.printPaymentSchedule();
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
