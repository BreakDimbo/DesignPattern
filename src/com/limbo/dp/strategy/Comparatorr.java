package com.limbo.dp.strategy;

/**
 * Created by Break.D on 7/19/16.
 */
public interface Comparatorr<Item> {
    int compare(Comparable<Item> a, Comparable<Item> b);
}
