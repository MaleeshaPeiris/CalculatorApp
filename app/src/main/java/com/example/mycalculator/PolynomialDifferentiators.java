package com.example.mycalculator;

import java.util.ArrayList;

public class PolynomialDifferentiators {

    String differenciatedPower;
    String differenciatedCoefficient;
    ArrayList<PolynomialData> differentiatedData = new ArrayList<PolynomialData>();
    RootFinder rootFinder = new RootFinder();

    public ArrayList<PolynomialData> differentiate(ArrayList<PolynomialData> elements){
        int x=0;
        if(elements.get(0).coefficient.equals("+")){
            elements.get(0).coefficient="+1";
        }
        for(int i=0;i<elements.size();i++){
            if(Integer.parseInt(elements.get(i).power) >0) {
                x = Integer.parseInt(elements.get(i).power) - 1;
                differenciatedPower = String.valueOf(x);
                differenciatedCoefficient = String.valueOf((x+1)* Integer.parseInt(elements.get(i).coefficient));
                PolynomialData p4 = new PolynomialData(differenciatedCoefficient,differenciatedPower);
                differentiatedData.add(p4);
            }
            else {
                break;
            }
        }
        return differentiatedData;
    }

}
