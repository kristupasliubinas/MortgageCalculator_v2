package com.mortgageCalculator;

public class Mortgage {
    private int principal;
    private float annualInterest;
    private byte years;

    final private byte MONTHS_IN_YEAR = 12;
    final private byte PERCENT = 100;


    public Mortgage(int principal, float annualInterest, byte years) {
        setPrincipal(principal);
        setAnnualInterest(annualInterest);
        setYears(years);
    }


    public double calculateMortgage() {
        float monthlyInterest = calculateMonthlyInterest();
        short numberOfPayments = calculateNumberOfPayments();
        double mortgage = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        return mortgage;
    }

    public float calculateMonthlyInterest() {
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }

    public short calculateNumberOfPayments() {
        return (short)(years * MONTHS_IN_YEAR);
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

    private byte getYears() {
        return years;
    }

    private float getAnnualInterest() {
        return annualInterest;
    }

    public int getPrincipal() {
        return principal;
    }
}
