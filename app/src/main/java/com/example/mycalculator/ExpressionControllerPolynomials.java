package com.example.mycalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class ExpressionControllerPolynomials extends ExpressionController {

    ArrayList<PolynomialData> data = new ArrayList<PolynomialData>();
    String[] values;
    String p=null;
    @Override
    public void clearData() {
        super.clearData();
    }

    @Override
    public int getOpCount(String value1) {
        this.value1=value1;
        opCount=0;
        for (int i=0; i < value1.length(); i++) {
            if (value1.charAt(i) == '+' || value1.charAt(i) == '-') {
                opCount++;
                operators.add(value1.charAt(i));
            }
        }
        return opCount;
    }

    @Override
    public void storeValues(String value1) {
        this.value1=value1;
        values = value1.split("\\+|\\-",opCount+1);
        numericValues = new ArrayList<String>(Arrays.asList(values));
        values=null;
    }

    public void splitPolynomial(){
        //String a = null;
        int x = numericValues.size();
        for(int i=0; i< x ; i++){
            if(numericValues.get(i).contains("X^")){
                p  = numericValues.get(i).replace("^","");
                values = p.split("X",2);
                PolynomialData p1 = new PolynomialData(values[0],values[1]);
                data.add(p1);
                values=null;
            }

            else if(numericValues.get(i).contains("X")){
                //values = numericValues.get(i).split("X",2);
                if(numericValues.get(i).equals("X")){
                    p = "1";
                    }
                else
                        {
                            p = numericValues.get(i).replace("X","");

                }
                PolynomialData p2 = new PolynomialData(p,"1");
                data.add(p2);
                values=null;
            }

            else {
                p = numericValues.get(i);
                PolynomialData p3 = new PolynomialData(p,"0");
                data.add(p3);
                values=null;

            }
        }

    }

    @Override
    public float getAnswer(String value1)
    {

        opCount = getOpCount(value1);
        storeValues(value1);
        splitPolynomial();
        return (float) 0.0;
    }
}
