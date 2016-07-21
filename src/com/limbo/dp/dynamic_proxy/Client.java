package com.limbo.dp.dynamic_proxy;

import com.limbo.dp.dynamic_proxy.invokeHandler.InvokeHandler;
import com.limbo.dp.dynamic_proxy.invokeHandler.TimeHanderImpl;

/**
 * Created by Break.D on 7/20/16.
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Tank t = new Tank();
        InvokeHandler ik = new TimeHanderImpl(t);
        Movable m = (Movable) Proxy.getProxyInstance(Movable.class,ik);
        m.move();

    }
}
