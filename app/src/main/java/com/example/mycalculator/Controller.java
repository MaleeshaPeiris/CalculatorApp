package com.example.mycalculator;



public class Controller {
    String num1;
    String num2;
    String fullText;
    String answerText;
    String value1;
    String value2;
    float val1,val2;
    boolean Numericstatus,isNumberOne,operatorStatus,functionStatus;
    int operatorIndex;
    //controller c = new controller();
    Validate validate = new Validate();
    Arithmetic arithmetic = new Arithmetic();

//public string getTextForPrinting(whole text fr printing)
    //

    public String clearData()
    {
      validate.clearData();
        num1 = "";
        num2 = "";
        fullText="";
        answerText="";
        val1=0;
        val2=0;
        return "";
    }


    public String numericTextControl(String num1,String num2) {
        this.num1 =num1;
        this.num2 = num2;

        if(num1==""){

            isNumberOne=true;
            Numericstatus = validate.isNumeric(num2);
            operatorStatus = validate.isOperator(num2);


            if (Numericstatus==true){
                fullText = num2;
            }


            else if(operatorStatus == true ) {
                fullText = "";
            }

            else{
                fullText="";
            }
        }
        else{
            fullText = num1+num2;
        }

        return fullText;
    }



    public String operatorTextControl(String num1,String num2) {
        this.num1 =num1;
        this.num2 = num2;

        if(num1==""){

            operatorStatus = validate.isOperator(num2);

            if(operatorStatus == true && num2=="-") {
                fullText = num1+num2;
            }
            else if(operatorStatus==true){
                fullText="";
            }
        }

        else {
            try {
                validate.value1 = Float.parseFloat(num1);
                val1=validate.value1;
            } catch (NumberFormatException e) {
                num2="";
            }
            value1= num1;
            fullText=num1+num2;
        }
        return fullText;
    }



    public String dotTextControl(String num1, String num2){
        this.num1 =num1;
        this.num2 = num2;

        if(num1=="") {

            fullText = num2;
        }
            else if(num1.endsWith("+") || num1.endsWith("-") || num1.endsWith("/") || num1.endsWith("x") || num1.endsWith(".")) {
                num2 = "";
                fullText = num1;
            }

            else if(num1.contains(".")){
            num2 = "";
            fullText = num1;
            }

            else{
                fullText = num1+num2;
        }
        return fullText;
    }



    public String equalControllerDisplayOne(String num1,String num2){
        this.num1 =num1;
        this.num2 = num2;

        if(num1==""){
                num2="";
                fullText = "";
        }

        else if(validate.hasOperator(num1)==false){

            fullText = num1+num2;
        }

        else if(validate.hasOperator(num1)){

            if(num1.endsWith("+") || num1.endsWith("-") || num1.endsWith("/") || num1.endsWith("x") || num1.endsWith(".")||num1.endsWith("=")) {
                num2="";
                fullText=num1;
            }

            else{
                fullText=num1+num2;
            }
        }


        return fullText;
    }



    public String equalControllerDisplayTwo(String num1,String num2){

        this.num1=num2;
        this.num2=num2;
        if(num1==""){
            num2="";
            answerText = "";
        }


        if(validate.hasOperator(num1)==false){

            answerText = num1;
        }

        else if(validate.hasOperator(num1)){

            if(num1.endsWith("+") || num1.endsWith("-") || num1.endsWith("/") || num1.endsWith("x") || num1.endsWith(".")) {
                answerText="";
            }

            else{
                val2 = validate.getValue2(num1);
                operatorIndex = validate.getOpIndex(num1);
                answerText = String.valueOf(arithmetic.calculateAnswer(val1,val2,operatorIndex,num1));

            }
        }

        return answerText;
    }


}