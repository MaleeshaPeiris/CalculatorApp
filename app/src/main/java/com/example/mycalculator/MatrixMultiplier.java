package com.example.mycalculator;

import java.util.ArrayList;

public class MatrixMultiplier extends MatrixController implements Runnable {

   // ArrayList<Matrix> matricesToMultiply = new ArrayList<Matrix>();
    //public enum TNAME{}
    String threadName;
    int resultRow,resultColumn;
   // MainActivity m1 = new MainActivity();
    double [][] finalMatrix = new double[0][0];
    int[] array;
    public MatrixMultiplier(ArrayList<Matrix> listMatrix, String tName) {
        this.matrixList = listMatrix;
        this.threadName=tName;
        resultRow= matrixList.get(0).data.length;
        resultColumn= matrixList.get(1).data[0].length;
    }

    public MatrixMultiplier(){}

    @Override
    public void run() {
        //twoDArray = matrixList.get(0).data;
       // rowSize = matrixList.get(0).getRow();
        int x = Integer.parseInt(threadName);
        if(finalMatrix.length == 0){
            finalMatrix = new double[resultRow][resultColumn];
            multiply(matrixList.get(0).data,matrixList.get(1).data,x);
        }
    }


    @Override
    public ArrayList<Matrix> storeMatrices(ArrayList<Matrix> matrixList) {
        return super.storeMatrices(matrixList);
    }

    @Override
    public void storeSingleMatrix(String text) {
        super.storeSingleMatrix(text);
    }

    public void multiply(double[][] matrix1, double[][] matrix2,int position) {

                int resultColumns = matrix2.length;
                int firstIndex = position/resultColumns;
                int secondIndex= position%resultColumns;
                double value = 0;
               // finalMatrix[firstIndex][secondIndex]= 0;
                for (int k = 0; k < resultColumns; k++) {
                    //finalMatrix[firstIndex][secondIndex] += matrix1[firstIndex][k] * matrix2[k][secondIndex];
                    value += matrix1[firstIndex][k] * matrix2[k][secondIndex];
                }
                MainActivity.resultMatrix[firstIndex][secondIndex]=value;

    }
}