package com.example.mycalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixController {
    String matrixText;
    int rowSize,columnSize;
    List<String> items = new ArrayList<String>();
    double[][] twoDArray;
    int index;
    //List<double[][]> listOfMatrices= new ArrayList<double[][]>();
    Matrix matrixObject,answerMatrix;
    ArrayList<Matrix> matrixList = new ArrayList<Matrix>();



    public ArrayList<Matrix> storeMatrices(ArrayList<Matrix> matrixList){

        for(index=0; index<matrixList.size();index++) {
            matrixText = matrixList.get(index).getTextData();
            rowSize = matrixList.get(index).getRow();
            columnSize = matrixList.get(index).getColumn();
            storeSingleMatrix(matrixText);
        }
        return matrixList;
    }

    public void storeSingleMatrix(String text){
        twoDArray = new double[rowSize][columnSize];
        items = Arrays.asList(matrixText.split("\\s*,\\s*"));
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                String x = items.get(columnSize * i + j);
                twoDArray[i][j] = Double.parseDouble(x);
            }
        }
        matrixObject = new Matrix(rowSize,columnSize,twoDArray);
        matrixList.add(matrixObject);
        //listOfMatrices.add(twoDArray);
    }

    public String getAnswer(double[][] answer){
        twoDArray=answer;
        StringBuilder sb = new StringBuilder();

        for (double[] row :twoDArray ) {
            sb.append(Arrays.toString(row));
        }

        String result = sb.toString();
        return result;
    }
}
