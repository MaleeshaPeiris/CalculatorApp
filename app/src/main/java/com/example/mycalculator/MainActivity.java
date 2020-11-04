package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.example.mycalculator.MatrixActivity.REQUEST_CODE;

public class MainActivity extends AppCompatActivity {


    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonAdd, buttonDiv, buttonClear, buttonSub, buttonEq, buttonMul;
    Button buttonX,buttonPower,buttonSquared;
    TextView diplay_line1, display_line2;
    ControllerNew mNewController;
    polynomialController mPolyController;
    Button buttonDot;
    LinearLayout polyView;
    static final int GET_MATRIX_DATA = 1;
    ArrayList<Matrix> mMatricesList = new ArrayList<Matrix>();
    MatrixController matrixController = new MatrixController();
    static double[][] resultMatrix;
    private static final int PERMISSION_REQUEST_STORAGE=1001;
    private static final int WRITE_REQUEST_CODE=41;
    String text;


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


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_MATRIX_DATA) {

            if (resultCode == RESULT_OK) {
                setResult(data);
            }
        }

        if (requestCode == WRITE_REQUEST_CODE && resultCode==RESULT_OK) {
            if(data != null){
                    Uri uri = data.getData();
                    try {
                        writeTextFromUri(uri);
                     } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menufile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_item:
                 mNewController.changeMode(ControllerNew.Mode.NORMAL);
                 polyView.setVisibility(View.GONE);
                 this.setTitle("NormalMode");
                return true;
            case R.id.upload_item:
                 mNewController.changeMode(ControllerNew.Mode.SCIENTIFIC);
                this.setTitle("ScientificMode");
                polyView.setVisibility(View.GONE);
                return true;
            case R.id.copy_item:
                polyView.setVisibility(View.VISIBLE);
                mNewController.changeMode(ControllerNew.Mode.ROOT);
                this.setTitle("RootCalculator");
                return true;
            case R.id.matrix_item:
                openMatrixActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void openMatrixActivity(){
        Intent intent = new Intent(this,MatrixActivity.class);
        startActivityForResult(intent,GET_MATRIX_DATA);
    }


    public void setResult(Intent intent){
        mMatricesList = intent.getParcelableArrayListExtra("matrixList");
        matrixController.storeMatrices(mMatricesList);
        if (!(matrixController.matrixList.get(0).data[0].length == matrixController.matrixList.get(1).data.length)) {
            display_line2.setText("Incorrect Matrix Format");
        }
        else {
            resultMatrix = new double[matrixController.matrixList.get(0).data.length][matrixController.matrixList.get(1).data[0].length];
            int arraySize = matrixController.matrixList.get(0).data.length * matrixController.matrixList.get(1).data[0].length;
            ExecutorService executor = Executors.newFixedThreadPool(arraySize);
            for (int i = 0; i < arraySize; i++) {
                Runnable worker = new MatrixMultiplier(matrixController.matrixList, "" + i);
                executor.execute(worker);
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            text = matrixController.getAnswer(resultMatrix);
            display_line2.setText(text);

            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},PERMISSION_REQUEST_STORAGE);
            }
            performFileSearchToWrite();
        }
    }


    private void performFileSearchToWrite(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/*");
        startActivityForResult(intent,WRITE_REQUEST_CODE);
    }



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void writeTextFromUri(Uri uri) throws IOException {
        try (OutputStream outputStream = getContentResolver().openOutputStream(uri);
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(Objects.requireNonNull(outputStream)))) {
            writer.write(text);
        }
    }
}