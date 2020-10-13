package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonAdd, buttonDiv, buttonClear, buttonSub, buttonEq, buttonMul;
    Button buttonX,buttonPower,buttonSquared;
    TextView diplay_line1, display_line2;
    ControllerNew mNewController;
    polynomialController mPolyController;
    Button buttonDot;
    LinearLayout polyView;


    @SuppressLint("WrongViewCast")
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
        buttonDiv = findViewById(R.id.buttondivide);
        buttonClear = findViewById(R.id.buttonclear);
        buttonEq = findViewById(R.id.buttonequals);
        buttonDot = findViewById(R.id.buttondot);
        buttonMul = findViewById(R.id.buttonmultiply);
        buttonX = findViewById(R.id.buttonX);
        buttonPower = findViewById(R.id.buttonpower);
        buttonSquared = findViewById(R.id.buttonsquared);

        diplay_line1 = findViewById(R.id.textView3);
        diplay_line1.setText(null);
        display_line2 = findViewById(R.id.textView2);
        display_line2.setText(null);

        mNewController = new ControllerNew();
        mPolyController = new polynomialController();
        polyView = (LinearLayout) findViewById(R.id.polyView);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button1.getText()));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button2.getText()));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button3.getText()));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button4.getText()));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button5.getText()));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button6.getText()));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button7.getText()));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button8.getText()));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button9.getText()));
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button0.getText()));
            }
        });



        buttonX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               diplay_line1.setText(mPolyController.xTextController((String) diplay_line1.getText(), (String) buttonX.getText()));
            }
        });

        buttonPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               diplay_line1.setText(mPolyController.powerTextController((String) diplay_line1.getText(), (String) buttonPower.getText()));
            }
        });

        buttonSquared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // diplay_line1.setText(mNewController.numericTextController((String) diplay_line1.getText(), (String) button0.getText()));
            }
        });


        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.dotTextControl((String) diplay_line1.getText(), (String) buttonDot.getText()));
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.operatorText((String) diplay_line1.getText(), (String) buttonAdd.getText()));
            }

        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.operatorText((String) diplay_line1.getText(), (String) buttonSub.getText()));

            }

        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.operatorText((String) diplay_line1.getText(), (String) buttonMul.getText()));

            }

        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diplay_line1.setText(mNewController.operatorText((String) diplay_line1.getText(), (String) buttonDiv.getText()));

            }

        });

        buttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_line2.setText(mNewController.equalDisplayTwo((String) diplay_line1.getText()));

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewController.clearController();
                diplay_line1.setText("");
                display_line2.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menufile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      //  Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.search_item:
                 mNewController.changeMode(ControllerNew.Mode.NORMAL);
                 polyView.setVisibility(View.GONE);
                return true;
            case R.id.upload_item:
                 mNewController.changeMode(ControllerNew.Mode.SCIENTIFIC);
                polyView.setVisibility(View.GONE);
                return true;
            case R.id.copy_item:
                polyView.setVisibility(View.VISIBLE);
                mNewController.changeMode(ControllerNew.Mode.ROOT);
              /*   switch (item.getItemId()){
                     case R.id.root:
                         mNewController.changeMode(ControllerNew.Mode.ROOT);
                         return true;
                     case R.id.green:
                         mNewController.changeMode(ControllerNew.Mode.ADDSUM);
                         return true;
                     case R.id.blue:
                         mNewController.changeMode(ControllerNew.Mode.MULDIV);
                         return true;
                 } */
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}