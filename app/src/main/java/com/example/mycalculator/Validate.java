package com.example.mycalculator;

public class Validate {
    String x,y;
    boolean status ;
    float value1,value2;
    int opIndex;
    int plusIndex;
    int minusIndex;
    int mulIndex;
    int divIndex;

    public void clearData(){

        opIndex = 0;
        x="";
        value1=0;
        value2 = 0;
    }


    public boolean isNumeric(String num1){
        try{
            Integer.parseInt(num1);
            x=num1;
            status = true;
        } catch (NumberFormatException e) {
            x=" ";
            status = false;
        }
        return status;
    }

    public boolean isOperator(String num1){
        if(num1=="+" || num1=="-" || num1=="x" || num1=="/"){
            status=true;
        }
        else{
            status = false;
        }
        return status;
    }



    public boolean hasOperator(String y){
        if(y.contains("+") || y.contains("-") || y.contains("/") || y.contains("x")){
            status = true;
        }
        else{
            status = false;
        }
        return true;
    }


    public int getOpIndex(String num1){
        x=num1;
        plusIndex = x.indexOf("+",0);
        minusIndex = x.indexOf("-",0);
        mulIndex = x.indexOf("x",0);
        divIndex = x.indexOf("/",0);
        if(plusIndex > 0){
            opIndex = plusIndex;
        }
        else if(minusIndex>0){
            opIndex = minusIndex;
        }
        else if(mulIndex>0){
            opIndex =mulIndex;
        }
        else if(divIndex>0){
            opIndex = divIndex;
        }
            return opIndex;
    }


    public float getValue2(String num1){
        opIndex = getOpIndex(num1);
        String x = num1.substring(opIndex+1,num1.length()-1);
        try {
            value2 = Float.parseFloat(x);
        }
        catch(NumberFormatException e) {
            clearData();
        }
        return value2;
    }



}
