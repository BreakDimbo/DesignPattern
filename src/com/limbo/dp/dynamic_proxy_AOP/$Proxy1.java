package com.limbo.dp.dynamic_proxy_AOP;import java.lang.reflect.Method;

public class $Proxy1 implements com.limbo.dp.dynamic_proxy_AOP.Movable{private com.limbo.dp.dynamic_proxy_AOP.invokeHandler.TimeHanderImpl h;public $Proxy1(com.limbo.dp.dynamic_proxy_AOP.invokeHandler.TimeHanderImpl h) {this.h = h;}@Override public void move() {try { Method md = com.limbo.dp.dynamic_proxy_AOP.Movable.class.getMethod("move");h.invoke(this, md);} catch(NoSuchMethodException e) { e.printStackTrace();}}}