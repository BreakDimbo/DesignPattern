package com.limbo.dp.strateg;

/**
 * Created by Break.D on 7/19/16.
 */
public class DataSort<Item> {
    //使用快速排序(切分-归并排序)

    public void sort(Comparable<Item>[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable<Item>[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(Comparable<Item>[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable<Item> v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == 0) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(Comparable<Item>[] a, int i, int j) {
        Comparable<Item> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(Comparable<Item> a, Comparable<Item> b) {
        if (a.compareTo((Item) b) < 0) return true;
        else return false;
    }

    public void p(Comparable<Item>[] a) {
        for(Comparable<Item> i : a) {
            System.out.println(i);
        }
    }

}
