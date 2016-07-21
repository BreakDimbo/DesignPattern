package com.limbo.dp.strategy;

/**
 * Created by Break.D on 7/19/16.
 */
public class Test {

    public static void main(String[] args) {
//        Double[] a = {1.0, 3.0, 2.0, 5.0, 1.0, 6.0, 9.0};
        Cat[] cats = new Cat[20];
        for (int i = 0; i < 20; i++) {
            cats[i] = new Cat();
            cats[i].setHeight(i+10);
            cats[i].setWeight(i*2);
        }
        DataSort<Cat> dataSort = new DataSort<>();

        dataSort.sort(cats);
        dataSort.p(cats);
    }

}
