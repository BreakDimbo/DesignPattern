package com.limbo.dp.factory.bean_factory_spring;

import com.limbo.dp.factory.normal_factory.Movable;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Break.D on 8/2/16.
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties pros = new Properties();
        pros.load(Test.class.getClassLoader().getResourceAsStream("com/limbo/dp/factory/spring.properties"));
        String vehicle = pros.getProperty("VehicleType");
        System.out.println(vehicle);
        Object o = Class.forName(vehicle).newInstance();
        Movable m = (Movable) o;
        m.run();

    }
}
