package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // Button[] button = new Button[10];
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonAdd,buttonDiv,buttonClear,buttonSub,buttonEq,buttonMul;
    TextView diplay_line1,display_line2;
    Controller mControler;
    Button buttonDot;
    float Res1,Res2,val1,val2;
    boolean print,Add,Addop,Sub,Subop,Mul,Mulop,Div,Divop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
        buttonAdd = findViewById(R.id.buttonplus);
        buttonSub = findViewById(R.id.buttonminus);
        buttonDiv =  findViewById(R.id.buttondivide);
        buttonClear = findViewById(R.id.buttonclear);
        buttonEq = findViewById(R.id.buttonequals);
        buttonDot = findViewById(R.id.buttondot);
        buttonMul = findViewById(R.id.buttonmultiply);
        diplay_line1 = findViewById(R.id.textView3);
        diplay_line1.setText(null);
        display_line2 = findViewById(R.id.textView2);
        display_line2.setText(null);
        mControler = new Controller();

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//get text for printing
               diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button1.getText().toString()));

            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button2.getText().toString()));
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button3.getText().toString()));
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button4.getText().toString()));
            }
        });

        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button5.getText().toString()));
            }
        });

        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button6.getText().toString()));
            }
        });

        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button7.getText().toString()));
            }
        });

        button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button8.getText().toString()));
            }
        });

        button9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button9.getText().toString()));
            }
        });

        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                diplay_line1.setText(mControler.numericTextControl((String) diplay_line1.getText(), button0.getText().toString()));
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.dotTextControl((String) diplay_line1.getText(), buttonDot.getText().toString()));
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.operatorTextControl((String) diplay_line1.getText(), buttonAdd.getText().toString()));

            }

        });

        buttonSub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.operatorTextControl((String) diplay_line1.getText(), buttonSub.getText().toString()));

            }

        });

        buttonMul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                diplay_line1.setText(mControler.operatorTextControl((String) diplay_line1.getText(), buttonMul.getText().toString()));

            }

        });

        buttonDiv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.operatorTextControl((String) diplay_line1.getText(), buttonDiv.getText().toString()));

            }

        });

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diplay_line1.setText(mControler.equalControllerDisplayOne((String) diplay_line1.getText(), buttonEq.getText().toString()));

                display_line2.setText(mControler.equalControllerDisplayTwo((String) diplay_line1.getText(), buttonEq.getText().toString()));

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mControler.clearData());
                display_line2.setText(mControler.clearData());
            }
        });

    }
}