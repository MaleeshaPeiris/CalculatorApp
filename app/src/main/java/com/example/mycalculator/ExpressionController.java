package com.example.mycalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ExpressionController {
    String value1;
    int opCount;
    ArrayList<Character> operators = new ArrayList<>();
    String[] values;
    float num1,num2;
    char operator;

    public void clearData(){
        operators.clear();
       Arrays.fill(values,null);

    }


    public int getOpCount(String value1){
        this.value1=value1;

        for (int i=0; i < value1.length(); i++) {
            if (value1.charAt(i) == '+' || value1.charAt(i) == '-' ||
                    value1.charAt(i) == '/' || value1.charAt(i) == '*') {
                opCount++;
                operators.add(value1.charAt(i));

            }
        }

        return opCount;
    }



    public float setValues(String value1){
        this.value1=value1;
        opCount=getOpCount(value1);
       values = value1.split("\\+|\\-|\\/|\\*",opCount+1);
        num1 = Float.parseFloat(values[0]);
        num2=0;
        int  j = 0;
        for(int i=1;i < values.length;i++){
            num2 = Float.parseFloat(values[i]);
            operator = operators.get(j);
            if(operator == '+'){
                num1 = num1 + num2;
                return num1;
            }
            else if(operator=='-'){
                num1 = num1 - num2;
                return num1;
            }
            else if(operator=='/') {
                num1 = num1 / num2;
                return num1;
            }
            else if(operator=='*'){
                num1= num1*num2;
            }

        }
        j++;
        return num1;
    }
/*

    public enum Operation {
        PLUS('+'),
        MINUS('-'),
        TIMES('*'),
        DIVIDE('/');
        private final char symbol;

        Operation(char symbol) {
            this.symbol = symbol; }


        public char toChar() {
            return symbol; }
        }

    public void checkOp(){
        if(Operation.PLUS.toChar()=='+') {

        }
    }
*/

}
