package com.example.mycalculator;

public class ControllerNew {

    float dTwoValue;
    String num1,num2,dOneFullText,dTwoFullText;
    boolean hasDisplayed;
    private ExpressionController currentController=null;
    private ExpressionController scientificController = new ExpressionContrllerExtended();
    private ExpressionController normalController = new ExpressionController();
    private ExpressionController rootCalculator = new ExpressionControllerPolynomials();

    public enum Mode{SCIENTIFIC,NORMAL,ROOT, ADDSUM,MULDIV}
    public Mode mMode;

    public String clearController(){
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


// cretae class called references and add static

    public void changeMode(Mode m){

            if(m== Mode.NORMAL) {
                currentController=normalController;
            }
            else if(m==Mode.SCIENTIFIC){
                currentController=scientificController;
            }
            else if(m==Mode.ROOT){
                currentController=rootCalculator;
            }
            else if(m==Mode.ADDSUM){
                currentController=rootCalculator;

            }
            else if(m==Mode.MULDIV){
                currentController=rootCalculator;
            }
            mMode=m;
    }



    public String numericTextController(String num1,String num2){
        this.num1=num1;
        this.num2=num2;
        if(hasDisplayed==true){
            clearController();
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
                if(num2 == "-"){
                    dOneFullText = "-";
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

                        // add code to restrict a number from having two dots
                        dOneFullText = num1 + num2;


                }
            }
        }
        return dOneFullText;
    }



}
