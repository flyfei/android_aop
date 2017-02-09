package com.tovi.aop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator arithmeticCalculatorProxy = (Calculator) new ArithmeticCalculatorInvocationHandler(new ArithmeticCalculator()).getProxy();
        Calculator argValidityProxy = (Calculator) new ArithmeticCalculatorArgsInvocationHandler(arithmeticCalculatorProxy).getProxy();
        try {
            arithmeticCalculatorProxy.add(10d, 10d);
            argValidityProxy.add(-10d, 10d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
