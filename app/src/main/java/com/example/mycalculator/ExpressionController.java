package com.example.mycalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ExpressionController {
    String value1;
    int opCount;
    ArrayList<Character> operators = new ArrayList<Character>();
    ArrayList<String> numericValues ;
    String[] values;
    float num1,num2;
    char operator;
    //boolean normalMode;

    public void clearData(){
        operators.clear();
      //  numericValues.clear();
    }


    public int getOpCount(String value1){
        this.value1=value1;
        opCount=0;
        for (int i=0; i < value1.length(); i++) {
            if (value1.charAt(i) == '+' || value1.charAt(i) == '-' ||
                    value1.charAt(i) == '/' || value1.charAt(i) == '*') {

                opCount++;
                operators.add(value1.charAt(i));

            }
        }

        return opCount;
    }



    public void storeValues(String value1){
        this.value1=value1;
        values = value1.split("\\+|\\-|\\/|\\*",opCount+1);
        numericValues = new ArrayList<String>(Arrays.asList(values));
        values=null;

    }




    public float getAnswer(String value1){
        this.value1=value1;
 //       numericValues.clear();
        operators.clear();
        opCount = getOpCount(value1);
        storeValues(value1);


        num1 = Float.parseFloat(numericValues.get(0));
        num2=0;
       int  j = 0;
        for(int i=1;i < numericValues.size();i++){
            num2 = Float.parseFloat(numericValues.get(i));
           operator = operators.get(j);

            if(operator == '+'){
                num1 = num1 + num2;
            }

            else if(operator=='-'){
                num1 = num1 - num2;
            }

            else if(operator=='/') {
                num1 = num1 / num2;
            }

            else if(operator=='*'){
                num1= num1*num2;
            }

           j++;
        }

        return num1;
    }


}
