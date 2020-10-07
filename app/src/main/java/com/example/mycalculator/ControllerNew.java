package com.example.mycalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class ControllerNew {

    float dTwoValue;
    String num1,num2,dOneFullText,dTwoFullText;
    boolean hasDisplayed;
    private boolean mNormalMode=true;
    private ExpressionController currentController=null;
    private ExpressionController scientificController = new ExpressionContrllerExtended();
    private ExpressionController normalController = new ExpressionController();
    ArrayList<String> numeratorValidator = new ArrayList<String>();
    String[] toValidateNumbers;
    int opCounttoValidate;


    public String clearClontroller(){
        num1="";
        num2="";
        hasDisplayed=false;
        dOneFullText="";
        scientificController.clearData();
        return "";
    }


    public ControllerNew(){
        currentController= normalController;
    }



    public void changeMode(boolean normalMode){
        if(normalMode==mNormalMode){
            return;
        }
        else{
            if(normalMode==true){
                currentController=normalController;
            }
            else{
                currentController=scientificController;

            }
            mNormalMode=normalMode;
        }
    }

    public String numericTextController(String num1,String num2){
        this.num1=num1;
        this.num2=num2;
        if(hasDisplayed==true){
            clearClontroller();
            dOneFullText = num2;

        }
        else{
            if(num1==""){
                dOneFullText=num2;
            }
            else{

                dOneFullText=num1+num2;
            }
        }

        return dOneFullText;

    }
    public String operatorText(String num1,String num2){
        this.num1=num1;
        this.num2=num2;
        if(hasDisplayed==true){
            dOneFullText="";
            hasDisplayed=false;
        }
        else{
            if(num1==""){
                if(num2=="-"){
                    dOneFullText= num2;
                }
                else {
                    dOneFullText = num1;
                }
            }
            else{
                if(num1.endsWith("+") || num1.endsWith("-") || num1.endsWith("/") || num1.endsWith("*") || num1.endsWith(".")) {
                    num2 = "";
                    dOneFullText = num1;
                }
                else {
                    numeratorValidator.clear();
                    storeValuestoValidate(num1);
                    dOneFullText = num1 + num2;


                }
            }
        }

        return dOneFullText;
    }

    public void storeValuestoValidate(String value1){
        getOpCounttoValidate(value1);
        toValidateNumbers = value1.split("\\+|\\-|\\/|\\*",opCounttoValidate+1);
        numeratorValidator = new ArrayList<String>(Arrays.asList(toValidateNumbers));
        toValidateNumbers=null;

    }

    public int getOpCounttoValidate(String value1){

        opCounttoValidate=0;
        for (int i=0; i < value1.length(); i++) {
            if (value1.charAt(i) == '+' || value1.charAt(i) == '-' ||
                    value1.charAt(i) == '/' || value1.charAt(i) == '*') {

                opCounttoValidate++;


            }
        }

        return opCounttoValidate;
    }


    public String equalDisplayTwo(String num1){
        this.num1 = num1;
        if(num1==""){
            dTwoFullText="";
        }

        else {

                dTwoValue = currentController.getAnswer(num1);
                dTwoFullText = String.valueOf(dTwoValue);
                hasDisplayed = true;
        }
        return dTwoFullText;
    }
   // public void deleteController(){}


    public String dotTextControl(String num1, String num2){
        this.num1=num1;
        this.num2=num2;
        if(hasDisplayed==true){
            dOneFullText="";
            hasDisplayed=false;
        }
        else{
            if(num1==""){
                    dOneFullText = num1;
            }
            else{
                if(num1.endsWith("+") || num1.endsWith("-") || num1.endsWith("/") || num1.endsWith("*") || num1.endsWith(".")) {
                    num2 = "";
                    dOneFullText = num1;
                }

                else {

                    if(numeratorValidator.get(numeratorValidator.size()-1).contains(".")) {
                        dOneFullText = num1;
                    }
                    else{
                        dOneFullText = num1 + num2;
                    }

                }
            }
        }






        return dOneFullText;
    }

}
