package com.example.mycalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExpressionContrllerExtended extends ExpressionController {
  //  ArrayList<String> newValueOrder = new ArrayList>String>();
    float answer, fracAnswer;
    String answerText;
    String[] newExpression;
    String x;

    public void clearData() {
        super.clearData();
        answer = (float) 0.0;
        answerText = "";
    }

    @Override
    public float getAnswer(String value1) {
        // return super.getAnswer(value1);
        x = value1;
        opCount = getOpCount(value1);
        storeValues(value1);
        // for(int i =0; ){}
        answer = getExtendedAnswer(value1);
        return answer;

    }

    public float getExtendedAnswer(String value1) {
        this.value1 = value1;

        if (!(operators.contains('*') || operators.contains('/'))) {
            opCount = getOpCount(value1);
            answer = super.getAnswer(value1);
        } else {
            //storeValues(value1);
            //opCount = getOpCount(value1);
            //  for(int i=0; i<operators.size(); i++) {
            value1 = setExpressionOrder(numericValues, operators);
            answer = super.getAnswer(value1);
            // }
        }


        return answer;
    }

//evaluate expression using binary

    public String setExpressionOrder(ArrayList<String> numericValues, ArrayList<Character> operators) {
        // numericValues=values;
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '*') {
                answerText = numericValues.get(i) + operators.get(i) + numericValues.get(i + 1);
                //getOpCount(answerText);
                // fracAnswer= super.getAnswer(answerText);
            } else if (operators.get(i) == '/') {
                answerText = numericValues.get(i) + operators.get(i) + numericValues.get(i + 1);
                //getOpCount(answerText);


            }

            if ((operators.get(i) == '*') == true || (operators.get(i) == '/') == true) {
                fracAnswer = super.getAnswer(answerText);

                numericValues.set(i, String.valueOf(fracAnswer));
                numericValues.remove(i + 1);
                getOpCount(value1);
                {
                    operators.remove(i);

                    value1 = x.replace(answerText, String.valueOf(fracAnswer));
                }

            }
            //  answer = getAnswer(numericValues,operators);


        }
        return value1;
    }
}
