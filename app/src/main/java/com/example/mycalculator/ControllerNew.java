package com.example.mycalculator;

public class ControllerNew {

    float dOneValue1,dOneValue2,dTwoValue;
    String num1,num2,num3,dOneFullText,dTwoFullText;
    boolean x,y,hasDisplayed;
    //ExpressionController eController = new ExpressionController();
    ExpressionController eController = new ExpressionContrllerExtended();

    public String clearClontroller(){
        num1="";
        num2="";
        hasDisplayed=false;
        dOneFullText="";
        eController.clearData();
        return "";
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
                    dOneFullText = num1 + num2;
                }
            }
        }

        return dOneFullText;
    }




    public String equalDisplayTwo(String num1){
        this.num1 = num1;
        if(num1==""){
            dTwoFullText="";
        }

        else {
            dTwoValue = eController.getAnswer(num1);
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
                    dOneFullText=num1+num2;
                }
            }
        }






        return dOneFullText;
    }

}
