package com.limbo.dp.strateg;

/**
 * Created by Break.D on 7/19/16.
 */
public class Cat implements Comparable<Cat> {
    private int height;
    private int weight;
    private Comparatorr<Cat> comparatorr = new CatWeightComparator();

    public void setComparatorr(Comparatorr<Cat> comparatorr) {
        this.comparatorr = comparatorr;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return height + "|" + weight;
    }

    @Override
    public int compareTo(Cat o) {
        return comparatorr.compare(this, o);
    }
}
