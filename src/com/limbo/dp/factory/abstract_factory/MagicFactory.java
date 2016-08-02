package com.limbo.dp.factory.abstract_factory;

/**
 * Created by Break.D on 8/2/16.
 */
public class MagicFactory extends Factory {
    @Override
    public Vehicle createVihicle() {
        return new Broom();
    }

    @Override
    public Food createFood() {
        return new Mushroom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }
}
