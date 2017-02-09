package com.tovi.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */

public class ArithmeticCalculatorArgsInvocationHandler implements InvocationHandler {
    private Object target = null;

    public ArithmeticCalculatorArgsInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin valid method [" + method.getName() + "] with args (" + Arrays.toString(args) + ")");
        for (Object arg : args) {
            this.argValidity((Double) arg);
        }
        return method.invoke(this.target, args);
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    private void argValidity(double arg) throws Exception {
        if (arg < 0) {
            throw new Exception("参数不能小于0");
        }
    }

}
