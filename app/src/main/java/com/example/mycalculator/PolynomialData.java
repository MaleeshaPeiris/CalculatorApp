package com.example.mycalculator;

public class PolynomialData implements Comparable {

    String power;
    String coefficient;
    PolynomialData p;

    public PolynomialData(String timesNumber, String power) {
        this.power = power;
        this.coefficient = timesNumber;
    }


    @Override
    public int compareTo(Object o) {
        this.p= (PolynomialData) o;
        int powerValue= Integer.parseInt(p.power);
        return powerValue- Integer.parseInt(this.power);
    }
}
