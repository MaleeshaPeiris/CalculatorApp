package com.example.mycalculator;

public class Arithmetic {

    float value1;
    float value2;
    int operatorIndex;
    String displayText,operator;
    float Answer;


    public float calculateAnswer(float value1,float value2,int opIndex,String displayText){
        this.value1=value1;
        this.value2=value2;
        operatorIndex=opIndex;
        this.displayText=displayText;
        operator = getOperator(opIndex,displayText);

        if(operator=="+"){
            Answer = value1 + value2;
        }
        else if(operator =="-"){
            Answer = value1-value2;
        }
        else if(operator =="/"){
            Answer = value1/value2;
        }
        else if(operator =="x"){
            Answer = value1*value2;
        }

        return Answer;
    }


    public String getOperator(int opIndex, String displayText){

        this.displayText = displayText;
        operatorIndex=opIndex;
        operator = String.valueOf(displayText.charAt(opIndex));
        return operator;
    }
}
