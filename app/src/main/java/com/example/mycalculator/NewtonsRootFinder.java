package com.example.mycalculator;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class NewtonsRootFinder extends RootFinder {
    float xOfXAnswer;
    float predictedRoot;
    float root;
    float x = initialGuess;
    //ExpressionControllerPolynomials ecp = new ExpressionControllerPolynomials();
    ArrayList<PolynomialData> differentiatedList = new ArrayList<PolynomialData>();
    PolynomialDifferentiators polyDifferentiator = new PolynomialDifferentiators();

    @Override
    public void clearData(){
        xOfXAnswer=0;
        predictedRoot=0;
        root=0;
        initialGuess=0;
        x=initialGuess;
        differentiatedList.clear();
    }

    @Override
    public float findRoots(ArrayList<PolynomialData> p) {
        differentiatedList = polyDifferentiator.differentiate(p);
        root = getRoot(p);
        return root;
    }


    public float valueofFX(ArrayList<PolynomialData> p,float x) {
        float q = 0;
       float returnVal = 0;
        for (int i = 0; i < p.size(); i++) {
            q = (float) Math.pow(x, Float.parseFloat(p.get(i).power)) * Float.parseFloat(p.get(i).coefficient);
            returnVal = returnVal + q;
        }
        return returnVal;
    }


    public float getRoot(ArrayList<PolynomialData> p) {
        float root = initialGuess;
        int count=0;
        do {
           root =  singleIteration(p,root);
           count++;
       }
        while (Math.abs(valueofFX(p,root)) > errorTolerance && count< noOfIterations );
        return root;
    }


    private float singleIteration(ArrayList<PolynomialData> function,float x){
        float functionValue = valueofFX(function,x);
        float temp_root= 0;
        if(functionValue==0){
            temp_root=x;
            return temp_root;
        }
        float difValue = valueofFX(differentiatedList,x);
        if(difValue==0){
            temp_root=temp_root+1;
        }
        else{
            temp_root = x - (valueofFX(function,x) / difValue);
        }
        return temp_root;
    }
}

