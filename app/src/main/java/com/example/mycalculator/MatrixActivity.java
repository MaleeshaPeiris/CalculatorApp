package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class MatrixActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_STORAGE=1000;
    private static final int READ_REQUEST_CODE=42;
    public static final int REQUEST_CODE = 1;
    String arrayText;
    int arrayRow,arrayColumn;
    ArrayList<Matrix> matricesList = new ArrayList<Matrix>();
    Button multiplyMatrixbtn,clearMatrixbtn,selectfile,buttonBack;
    TextView matrixTextView;
    Matrix matrix1;
    boolean hasExtras=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix_activity);

        //Requesting permission to read
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST_STORAGE);
        }

        buttonBack = findViewById(R.id.backButton);
        selectfile = findViewById(R.id.selectFileButton);
        clearMatrixbtn = findViewById(R.id.clearMatrixButton);
        multiplyMatrixbtn = findViewById(R.id.multiplyMatrixButton);
        matrixTextView = findViewById(R.id.matrixText);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    backToMain();
            }
        });
        selectfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               performFileSearch();
            }
        });
        multiplyMatrixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasExtras==false){
                    Toast.makeText(getBaseContext(), "Select Files To Mltiply",Toast.LENGTH_SHORT).show();
                }
                else {

                    multiplyMatrices();
                }
            }
        });
    }


    private void performFileSearch(){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/*");
        startActivityForResult(intent,READ_REQUEST_CODE);
    }




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == READ_REQUEST_CODE && resultCode==RESULT_OK) {
            if(data != null){
                hasExtras=true;
                if(null != data.getClipData()) { // checking multiple selection or not
                    for(int i = 0; i < data.getClipData().getItemCount(); i++) {
                        Uri uri = data.getClipData().getItemAt(i).getUri();
                        try {
                            readTextFromUri(uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    Uri uri = data.getData();
                    try {
                        readTextFromUri(uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void readTextFromUri(Uri uri) throws IOException {
        try (InputStream inputStream = getContentResolver().openInputStream(uri);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("row")) {
                    arrayRow= Integer.parseInt(line.replace("row-",""));
                }
                if (line.contains("column")) {
                    arrayColumn= Integer.parseInt(line.replace("column-",""));
                }
                if(!(line.contains("row"))&& !(line.contains("column"))){

                    if(line.equals("")){
                        continue;
                    }
                    else {
                        arrayText=line;
                        matrix1=new Matrix(arrayRow,arrayColumn,arrayText);
                        matricesList.add(matrix1);
                    }
                }
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==PERMISSION_REQUEST_STORAGE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Permission Not Granted",Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }


    public void backToMain(){
        Intent openMainActivity = new Intent(MatrixActivity.this, MainActivity.class);
        finish();
    }

    public void multiplyMatrices(){
        //getIntent().putParcelableArrayListExtra("matrixList",matricesList);
        Intent openMainActivity = new Intent(MatrixActivity.this, MainActivity.class);
        openMainActivity.putParcelableArrayListExtra("matrixList",matricesList);
        setResult(RESULT_OK,openMainActivity);
      //openMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
      //startActivityForResult(openMainActivity, REQUEST_CODE);
        finish();
    }


}