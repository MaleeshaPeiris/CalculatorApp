package com.example.mycalculator;

import java.util.ArrayList;
// controlling expression for calculations in scientific mode
public class ExpressionContrllerExtended extends ExpressionController {
    ArrayList<String> newValueOrder = new ArrayList<String>();
    float answer;
    String answerText;
    String x;

    public void clearData() {
        super.clearData();
        answer = (float) 0.0;
        newValueOrder.clear();
        answerText = "";
    }

    @Override
    public float getAnswer(String value1) {
        // return super.getAnswer(value1);
        x = value1;
        opCount = getOpCount(value1);
        storeValues(value1);

        if(operators.size()==numericValues.size()){

            for (int i = 0; i < operators.size(); i++) {

                newValueOrder.add(String.valueOf(operators.get(i)));
                newValueOrder.add(numericValues.get(i));
            }

            String x = newValueOrder.get(0)+newValueOrder.get(1);
            newValueOrder.remove(0);
            newValueOrder.set(0,x);
            answerText = finalAnswer(newValueOrder);
            answer = Float.parseFloat(answerText);
            return answer;
        }

        else {
            for (int i = 0; i < operators.size(); i++) {

                newValueOrder.add(numericValues.get(i));
                newValueOrder.add(String.valueOf(operators.get(i)));
            }

            newValueOrder.add(numericValues.get(operators.size()));
            answerText = finalAnswer(newValueOrder);
            answer = Float.parseFloat(answerText);
            return answer;
        }

    }




    public String finalAnswer(ArrayList<String> array){
        if(array.contains("*")&& array.contains("/")) {
          //  while (!array.contains("*")) {
            if(array.indexOf("*")>array.indexOf("/")){
                int i = array.indexOf("/");
                float temp = Float.parseFloat(array.get(i - 1)) / Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            else{
                int i = array.indexOf("*");
                float temp = Float.parseFloat(array.get(i - 1)) * Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            finalAnswer(array);
        }


        if(array.contains("*") ^ array.contains("/")){
            if(array.indexOf("/") == -1 ){
                int i = array.indexOf("*");
                float temp = Float.parseFloat(array.get(i - 1)) * Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            else{

                int i = array.indexOf("/");
                float temp = Float.parseFloat(array.get(i - 1)) / Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            finalAnswer(array);
        }


        if(array.contains("+")&& array.contains("-")) {
            //  while (!array.contains("*")) {
            if(array.indexOf("+")>array.indexOf("-")){
                int i = array.indexOf("-");
                float temp = Float.parseFloat(array.get(i - 1)) - Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            else{
                int i = array.indexOf("+");
                float temp = Float.parseFloat(array.get(i - 1)) + Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            finalAnswer(array);
        }


        if(array.contains("+") ^ array.contains("-")){
            if(array.indexOf("-") == -1 ){
                int i = array.indexOf("+");
                float temp = Float.parseFloat(array.get(i - 1)) + Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            else{

                int i = array.indexOf("-");
                float temp = Float.parseFloat(array.get(i - 1)) - Float.parseFloat(array.get(i + 1));
                String tempString = String.valueOf(temp);
                array.set(i - 1, tempString);
                array.remove(i);
                array.remove(i);
            }
            finalAnswer(array);
        }

        answerText = array.get(0);
        return answerText;
    }







}
