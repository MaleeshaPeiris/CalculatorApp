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
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void getAnswer_isCorrect() {
        ExpressionContrllerExtended e = new ExpressionContrllerExtended();
        float x = e.getAnswer("30 + 34 -1");
        assertEquals(63.0, x);
    }

    @Test
    public void getSuperAnswer_isCorrect() {
        ExpressionController e = new ExpressionController();
        float x = e.getAnswer("30 + 34 -1");
        assertEquals(63.0, x);
    }


/*
    @Test
    public void setExpressionOrer_isCorrect(){
        ExpressionContrllerExtended e2 = new ExpressionContrllerExtended();
        ArrayList<Character> characters = new ArrayList<Character>();
        characters.add('+');
        characters.add('*');
        characters.add('-');
        characters.add('/');
        String[] strng = {"23","2","4","1","2"};
        String newExpression = e2.setExpressionOrder(strng,characters);
        assertEquals(30.5,newExpression);

    } */

}