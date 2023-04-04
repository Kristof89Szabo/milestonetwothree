package com.exam.algo.sort;

import java.util.Arrays;

public class S02InsertionSort {

    public static void main(String[] args) {
        /*
         BigO(n2)

        2 reszre oszthatjuk az array-t. Sorted es unsorted.
        Megnezzuk a 0. indexen levo elemet,  ez mar sorted.
        Majd kiszedjuk az elso indexen levot.
        Ha ez kisebb mint a 0. indexen levot, akkor megcsereljuk a 2. szamot.
        Igy a 0.

         */
        System.out.println(Arrays.toString(makeInsertionSort(new int[]{9, 8, 3, 13, 87, 12, 99})));

    }

    private static int[] makeInsertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int element = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > element) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = element;
        }
        return a;
    }

}
