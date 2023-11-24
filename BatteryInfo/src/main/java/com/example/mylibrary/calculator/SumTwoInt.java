package com.example.mylibrary.calculator;

public class SumTwoInt {

    static {
        System.loadLibrary("native-lib");
    }

    public native int sumTwoValues(int a, int b);

}
