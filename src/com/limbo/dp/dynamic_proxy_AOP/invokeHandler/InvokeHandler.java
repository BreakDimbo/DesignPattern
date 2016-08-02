package com.limbo.dp.dynamic_proxy_AOP.invokeHandler;

import java.lang.reflect.Method;

/**
 * Created by Break.D on 7/21/16.
 */
public interface InvokeHandler {
    void invoke(Object o, Method m);
}
