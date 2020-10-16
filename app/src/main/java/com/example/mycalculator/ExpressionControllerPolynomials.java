package com.example.mycalculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ExpressionControllerPolynomials extends ExpressionController {

    ArrayList<PolynomialData> data = new ArrayList<PolynomialData>();
    ArrayList<Object> firstExpression = new ArrayList<Object>();
    ArrayList<Object> orderedExpression = new ArrayList<Object>();
    RootFinder rootFinder = new NewtonsRootFinder();


    String[] values;
    String p=null;
    @Override
    public void clearData() {
        data.clear();
        p="";
        rootFinder.clearData();
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
        if(values[0].equals("")){
            numericValues.remove(0);
        }
        values=null;
    }





    public void splitPolynomial(){

        int x = numericValues.size();
        for(int i=0; i< x ; i++){
            if(numericValues.get(i).contains("X^")){
                p  = numericValues.get(i).replace("^","");
                values = p.split("X",2);
                PolynomialData p1 = new PolynomialData(values[0], values[1]);
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



    public void orderedExpression(ArrayList<PolynomialData> x){
        this.data = x;
        Collections.sort(data);
    }




    @Override
    public float getAnswer(String value1)
    {

        opCount = getOpCount(value1);
        storeValues(value1);
        splitPolynomial();
        if(operators.size()== numericValues.size()){



            for(int i=0; i<operators.size();i++){
                data.get(i).coefficient = operators.get(i)+ data.get(i).coefficient;
            }

        }
        else {
            data.get(0).coefficient = "+" + data.get(0).coefficient;
            for (int i = 1; i < operators.size() + 1; i++) {
                data.get(i).coefficient = operators.get(i - 1) + data.get(i).coefficient;
            }
        }
        orderedExpression(data);

        return rootFinder.findRoots(data);
    }


}
