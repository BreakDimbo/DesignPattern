package com.limbo.dp.factory.normal_factory;

/**
 * Created by Break.D on 8/2/16.
 */
public class Test {
    //普通工厂只能处理单个的产品, 产生产品系列时会很麻烦
    public static void main(String[] args) {
        Factory factory = new CarFactory();
        Movable m = factory.create();
        m.run();
    }
}
