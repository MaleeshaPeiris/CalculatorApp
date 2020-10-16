package com.example.mycalculator;

public class polynomialController extends ControllerNew {

    @Override
    public String clearController() {
        return super.clearController();
    }


    @Override
    public void changeMode(Mode m) {
        super.changeMode(m);
    }

    @Override
    public String numericTextController(String num1, String num2) {
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
                if(num1.endsWith("X")){
                    dOneFullText = num1;
                }
                else {
                    dOneFullText = num1 + num2;
                }
            }
        }
        return dOneFullText;
    }

    @Override
    public String operatorText(String num1, String num2) {
        return super.operatorText(num1, num2);

    }

    @Override
    public String equalDisplayTwo(String num1) {
        return super.equalDisplayTwo(num1);
    }

    @Override
    public String dotTextControl(String num1, String num2) {
        return super.dotTextControl(num1, num2);
    }



    public String powerTextController(String num1,String num2){
        this.num1=num1;
        this.num2=num2;

       if(hasDisplayed==true){
           dOneFullText=num1;
           hasDisplayed=false;
       }
       else{
           if(num1==""){
               dOneFullText=num1;
           }
           else{
               if(num1.endsWith("X")){
                   dOneFullText=num1+num2;
               }
               else{
                   dOneFullText=num1;
               }
           }

       }

        return dOneFullText;
    }



    public String xTextController(String num1,String num2){
        this.num1=num1;
        this.num2=num2;


        if(hasDisplayed==true){
            clearController();
            dOneFullText=num2;
            hasDisplayed=false;
        }
        else{
            if(num1.endsWith("X") || num1.endsWith("^")){
                dOneFullText=num1;
            }
            else{
                    dOneFullText = num1 + num2;
            }

        }

        return dOneFullText;
    }
}
