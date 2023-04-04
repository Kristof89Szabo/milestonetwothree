package com.exam.algo.search;

public class S03RecursionLinearSearch {

    public static void main(String[] args) {
        System.out.println(recursiveLinerSearch(new int[]{1, 2, 3, 4, 18}, 0, 18));
    }

    private static int recursiveLinerSearch(int[] a, int i, int x) {
        if (i > a.length - 1) {
            return -1;
        } else if (a[i] == x) {
            return i;
        } else {
            System.out.println("index at:" + i);
            return recursiveLinerSearch(a, i + 1, x);
        }
    }

}
