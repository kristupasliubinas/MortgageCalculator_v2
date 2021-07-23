package com.mortgageCalculator;

import java.util.Scanner;

public class Console {
    // This class is responsible only for INPUT concerns
    public static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt, double lowerLimit, double upperLimit) {
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
