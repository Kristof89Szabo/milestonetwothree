package com.exam.algo.search;

public class S04RecursionBinarySearch {

    public static void main(String[] args) {

        System.out.println(recursiveBinarySearch(new int[]{1, 5, 7, 9, 13, 17, 19, 20}, 0, 7, 19));

    }

    private static int recursiveBinarySearch(int[] a, int p, int r, int x) {
        if (p > r) {
            return -1;
        } else {
            int q = (p + r) / 2; //Array felezo

            if (a[q] == x) {
                return q;
            } else if (a[q] > x) {
                return recursiveBinarySearch(a, p, q - 1, x);
            } else {
                return recursiveBinarySearch(a, q+1, r, x);
            }
        }
    }

}
