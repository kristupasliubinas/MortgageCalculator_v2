package com.mortgageCalculator;

public class Mortgage {
    // This class is responsible only for CALCULATION concerns
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;


    public Mortgage(int principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }
    // Overloaded constructor which reads the values of principal, annualInterest and years itself - no need to provide them when calling the constructor
    public Mortgage(){
        this(
                (int) Console.readNumber("Principal (£1K - £1M): ", 1000, 1_000_000),
                (float) Console.readNumber("Annual Interest Rate: ", 1, 30),
                (byte) Console.readNumber("Period (Years): ", 1, 30));
    }


    public float calculateMonthlyInterest() {
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }

    public short calculateNumberOfPayments() {
        return (short)(years * MONTHS_IN_YEAR);
    }

    public double calculateMortgage() {
        float monthlyInterest = calculateMonthlyInterest();
        short numberOfPayments = calculateNumberOfPayments();
        return principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    public double calculateRemainingBalance(int paymentsMade) {
        float monthlyInterest = calculateMonthlyInterest();
        short numberOfPayments = calculateNumberOfPayments();
        return principal * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), paymentsMade)) / (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }

    public double[] calculatePaymentSchedule() {
        short numberOfPayments = calculateNumberOfPayments();
        double[] paymentSchedule = new double[numberOfPayments];

        for (int paymentsMade = 1; paymentsMade <= numberOfPayments; paymentsMade++)
            paymentSchedule[paymentsMade - 1] = calculateRemainingBalance(paymentsMade);

        return paymentSchedule;
    }


    private void setYears(byte years) {
        if (years <= 0)
            throw new IllegalArgumentException("Years cannot be 0 or less");
        this.years = years;
    }

    private void setAnnualInterest(float annualInterest) {
        if (annualInterest <= 0)
            throw new IllegalArgumentException("Annual Interest cannot be 0 or less");
        this.annualInterest = annualInterest;
    }

    private void setPrincipal(int principal) {
        if (principal <= 0)
            throw new IllegalArgumentException("Principal cannot be 0 or less");
        this.principal = principal;
    }
}
