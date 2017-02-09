package com.tovi.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author <a href='mailto:zhaotengfei9@gmail.com'>Tengfei Zhao</a>
 */

public class ArithmeticCalculatorInvocationHandler implements InvocationHandler {
    private Object target = null;

    public ArithmeticCalculatorInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("the method [" + method.getName() + "] begin with args (" + Arrays.toString(args) + ")");
        Object result = method.invoke(this.target, args);
        System.out.println("the method [" + method.getName() + "] end with result (" + result + ")");
        return result;
    }
    public Object getProxy () {
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

}
