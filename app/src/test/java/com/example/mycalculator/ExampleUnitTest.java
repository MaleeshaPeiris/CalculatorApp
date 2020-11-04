package com.example.mycalculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {




    @Test
    public void getAnswer_isCorrect1() {
        ExpressionContrllerExtended e = new ExpressionContrllerExtended();
       // float x = e.getAnswer("30 + 34 -1");
        float y = e.getAnswer("23+55+21-8*2");
       // assertEquals(63.0, x,0.1);
        assertEquals(83.0,y,0.01);
    }
    
    @Test
    public void getAnswer_isCorrect2() {
        ExpressionContrllerExtended e1 = new ExpressionContrllerExtended();
        float y = e1.getAnswer("2*2*0*2");
        assertEquals(0.0,y,0.01);
    }


    @Test
    public void getAnswer_isCorrect3() {
        ExpressionContrllerExtended e1 = new ExpressionContrllerExtended();
        // float x = e.getAnswer("30 + 34 -1");
        float y = e1.getAnswer("5*2+6/0");
        // assertEquals(63.0, x,0.1);
        assertEquals("Divide by zero gives infinity as result", true, Float.isInfinite(y));
    }


    @Test
    public void getAnswer_isCorrect4() {
        ExpressionContrllerExtended e1 = new ExpressionContrllerExtended();
        // float x = e.getAnswer("30 + 34 -1");
        float y = e1.getAnswer("5.7*2.9+6/9.2");
        // assertEquals(63.0, x,0.1);
        assertEquals(17.182,y,0.01);
    }

    @Test
    public void dotTextController_isCorrect1(){
        ControllerNew c = new ControllerNew();
        String x = c.dotTextControl("80+60",".");
        assertEquals("80+60.",x);
    }


    @Test
    public void dotTextController_isCorrect2(){
        ControllerNew c1 = new ControllerNew();
        String x = c1.dotTextControl("80+60.",".");
        assertEquals("80+60.",x);
    }

    @Test
    public void dotTextController_isCorrect3(){
        ControllerNew c2 = new ControllerNew();
        String x = c2.dotTextControl("80.9+60",".");
        assertEquals("80.9+60.",x);
    }

    @Test
    public void dotTextController_isCorrect4(){
        ControllerNew c3 = new ControllerNew();
        String x = c3.dotTextControl("80.9+60.",".");
        assertEquals("80.9+60.",x);
    }

    @Test
    public void dotTextController_isCorrect5(){
        ControllerNew c2 = new ControllerNew();
        String x = c2.dotTextControl("80.9+60.0",".");
        assertEquals("80.9+60.0",x);
    }


    @Test
    public void numericTextController_isCorrect1(){
        ControllerNew c6 = new ControllerNew();
        String p = c6.numericTextController("0","3");
        assertEquals("03",p);

    }

    @Test
    public void numericTextController_isCorrect2(){
        ControllerNew c6 = new ControllerNew();
        String p = c6.numericTextController("","3");
        assertEquals("3",p);
    }


    @Test
    public void operatorTextController_isCorrect1(){
        ControllerNew c6 = new ControllerNew();
        String p = c6.operatorText("","/");
        assertEquals("",p);

    }

    @Test
    public void operatorTextController_isCorrect2(){
        ControllerNew c6 = new ControllerNew();
        String p = c6.operatorText("","-");
        assertEquals("-",p);
    }

    @Test
    public void operatorTextController_isCorrect3(){
        ControllerNew c6 = new ControllerNew();
        String p = c6.operatorText("5-","/");
        assertEquals("5-",p);

    }

    @Test
    public void operatorTextController_isCorrect4(){
        ControllerNew c6 = new ControllerNew();
        String p = c6.operatorText("2.","-");
        assertEquals("2.",p);
    }

    @Test
    public void NewtonsRootFinder_isCorrect1(){   // normal situation
        NewtonsRootFinder nrf = new NewtonsRootFinder();
        PolynomialData pData1 = new PolynomialData("+1","2");
        PolynomialData pData2 = new PolynomialData("+2","1");
        PolynomialData pData3 = new PolynomialData("+1","0");
        ArrayList<PolynomialData> p1 = new ArrayList<PolynomialData>();
        p1.add(pData1);
        p1.add(pData2);
        p1.add(pData3);
        float x =nrf.findRoots(p1);
        assertEquals("-0.9921875",x);
    }


    @Test
    public void NewtonsRootFinder_isCorrect2(){ // 0/0 situation
        NewtonsRootFinder nrf = new NewtonsRootFinder();
        PolynomialData pData1 = new PolynomialData("4","2");
      //  PolynomialData pData2 = new PolynomialData("2","0");
      //  PolynomialData pData3 = new PolynomialData("1","0");
        ArrayList<PolynomialData> p2 = new ArrayList<PolynomialData>();
        p2.add(pData1);
     //   p1.add(pData2);
      //  p1.add(pData3);
        float x =nrf.findRoots(p2);
        assertEquals("0.0",x);
    }


    @Test
    public void NewtonsRootFinder_isCorrect3(){ /// divided by zero situation
        NewtonsRootFinder nrf = new NewtonsRootFinder();
        PolynomialData pData1 = new PolynomialData("4","1");
        PolynomialData pData2 = new PolynomialData("2","0");
        //  PolynomialData pData3 = new PolynomialData("1","0");
        ArrayList<PolynomialData> p3 = new ArrayList<PolynomialData>();
        p3.add(pData1);
        p3.add(pData2);
        //  p1.add(pData3);
        float x =nrf.findRoots(p3);
        assertEquals("0.0",x);
    }


/*
    @Test
    public void splitPolynomial_isCorrect(){
        ExpressionControllerPolynomials e1 = new ExpressionControllerPolynomials();
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("3X^3");
        a1.add("4X^2");
        a1.add("5X");
        a1.add("2");
        ArrayList<PolynomialData> p = e1.splitPolynomial(a1);
        System.out.println(p);

    } */


}