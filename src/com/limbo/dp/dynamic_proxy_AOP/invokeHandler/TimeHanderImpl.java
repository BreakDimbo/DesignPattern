package com.limbo.dp.dynamic_proxy_AOP.invokeHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Break.D on 7/21/16.
 */
public class TimeHanderImpl implements InvokeHandler {

    private Object target;

    public TimeHanderImpl(Object target) {
        this.target = target;
    }


    @Override
    public void invoke(Object o, Method m) {
        long var1 = System.currentTimeMillis();
        System.out.println("起始时间: " + var1);
        System.out.println(m);

        try {
            m.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        long var3 = System.currentTimeMillis();
        System.out.println("Tank moved " + (var3 - var1) + " seconds");
    }
}
