package com.limbo.dp.dynamic_proxy_AOP;

/**
 * Created by Break.D on 7/20/16.
 */
public class Tank implements Movable {
    @Override
    public void move() {
        try {
            Thread.sleep((long) (Math.random() * 5000));
            System.out.println("Tank is moving....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
