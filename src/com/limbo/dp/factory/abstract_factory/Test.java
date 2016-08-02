package com.limbo.dp.factory.abstract_factory;

/**
 * Created by Break.D on 8/2/16.
 */
public class Test {
    public static void main(String[] args) {

        //抽象工厂可以产生系列产品,但是不能产生新的产品品种

        Factory factory = new MagicFactory();

        Vehicle m = factory.createVihicle();
        Food f = factory.createFood();
        Weapon w = factory.createWeapon();

        m.run();
        f.printName();
        w.shoot();
    }
}
