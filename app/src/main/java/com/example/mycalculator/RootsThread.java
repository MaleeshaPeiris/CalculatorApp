package com.example.mycalculator;
import java.util.ArrayList;

public class RootsThread implements Runnable {
   ArrayList<PolynomialData> polyData;
   RootFinder nRootFinder = new NewtonsRootFinder();
   private float rootValue;
   private ThreadCallBack tCallback;

   public RootsThread(ArrayList<PolynomialData> polyData, ThreadCallBack callback, float initialGuess){
       tCallback=callback;
       this.polyData=polyData;
       nRootFinder.initialGuess=initialGuess;
   }

    @Override
    public void run() {
       rootValue =  nRootFinder.findRoots(polyData);
       tCallback.onRootRecieve(rootValue);
    }



}
