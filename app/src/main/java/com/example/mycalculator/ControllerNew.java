package com.example.mycalculator;

public class ControllerNew {

    float dTwoValue;
    String num1,num2,dOneFullText,dTwoFullText;
    boolean hasDisplayed;
    private ExpressionController currentController=null;
    private ExpressionController scientificController = new ExpressionContrllerExtended();
    private ExpressionController normalController = new ExpressionController();
    private ExpressionController rootCalculator = new ExpressionControllerPolynomials();

    public enum Mode{SCIENTIFIC,NORMAL,ROOT}
    public Mode mMode;

    public String clearController(){
        num1="";
        num2="";
        hasDisplayed=false;
        dOneFullText="";
        scientificController.clearData();
        rootCalculator.clearData();
        return "";
    }


    public ControllerNew(){
        currentController= normalController;
    }


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
           /* else if(m==Mode.ADDSUM){
                currentController=rootCalculator;

            }
            else if(m==Mode.MULDIV){
                currentController=rootCalculator;
            } */
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
                if(num2.equals("-")){
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





    public String dotTextControl(String num1, String num2){
        this.num1=num1;
        this.num2=num2;
        if(hasDisplayed==true){
            dOneFullText="";
            hasDisplayed=false;
        }
        else{
            if(num1==""){
                    dOneFullText = "0.";
            }
            else{
                if(num1.endsWith(".") || num1.endsWith("X")) {
                    num2 = "";
                    dOneFullText = num1;
                }
                if(num1.endsWith("-") || num1.endsWith("+")  || num1.endsWith("/") || num1.endsWith("*")){
                    dOneFullText= num1 + "0.";
                }

                //if(){} add code to restrict a number from having two dots

                else {
                        dOneFullText = num1 + num2;
                }
            }
        }
        return dOneFullText;
    }



}
