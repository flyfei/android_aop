package com.tovi.aop;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */

public class ArithmeticCalculator implements Calculator {
    @Override
    public double add(double num1, double num2) throws Exception {
        return num1 + num2;
    }

    @Override
    public double sub(double num1, double num2) throws Exception {
        return num1 - num2;
    }
}
