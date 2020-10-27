package com.example.mycalculator;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Matrix implements  Parcelable {
    private int row;
    private int column;
    double[][] data;
    String textData;

    public Matrix(int row, int column, double[][] data) {
        this.row = row;
        this.column = column;
        this.data = data;
    }
    public Matrix(int row, int column, String textData) {
        this.row = row;
        this.column = column;
        this.textData = textData;
    }

    protected Matrix(Parcel in) {
        row = in.readInt();
        column = in.readInt();
        textData=in.readString();

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String getTextData() {
        return textData;
    }


    public static final Creator<Matrix> CREATOR = new Creator<Matrix>() {
        @Override
        public Matrix createFromParcel(Parcel in) {
            return new Matrix(in);
        }

        @Override
        public Matrix[] newArray(int size) {
            return new Matrix[size];
        }
    };




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(row);
        dest.writeInt(column);
        dest.writeString(textData);
    }
}
