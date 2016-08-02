package com.limbo.dp.factory.abstract_factory;

/**
 * Created by Break.D on 8/2/16.
 */
public class DefaultFactory extends Factory {
    @Override
    public Vehicle createVihicle() {
        return new Car();
    }

    @Override
    public Food createFood() {
        return new Apple();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }
}
