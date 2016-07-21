package com.limbo.dp.strategy;

/**
 * Created by Break.D on 7/19/16.
 */
public class CatWeightComparator implements Comparatorr<Cat> {

    @Override
    public int compare(Comparable<Cat> a, Comparable<Cat> b) {
        if (a instanceof Cat && b instanceof Cat) {
            Cat ca = (Cat) a;
            Cat cb = (Cat) b;
            if (ca.getWeight() < cb.getWeight()) return -1;
            else if (ca.getWeight() > cb.getWeight()) return 1;
            else return 0;
        }
        return -100;
    }
}

