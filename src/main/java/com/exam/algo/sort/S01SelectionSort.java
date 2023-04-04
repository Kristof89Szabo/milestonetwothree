package com.exam.algo.sort;

import java.util.Arrays;

public class S01SelectionSort {

    public static void main(String[] args) {
        /*
        Keressuk meg a legkissebbet:  BigO(n2)

        - 6, 5, 10, 9, 7 -> Megkeressuk a legkisebbet az elejerol majd azt berakjuk index 0-ra.
        - 5, 6, 10, 9, 7 -> 6 a masodik legkisebb ott hagyjuk. Majd elkezdjuk a 10tol megint vegignezni
        - 5, 6, 7, 10, 9 -> 7 volt a legkisebb majd berakjuk a 2. index-re. stbstb
         */
        System.out.println(Arrays.toString(makeSelectionSort(new int[]{9, 8, 3, 13, 87, 12, 99})));
    }

    private static int[] makeSelectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minimum = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minimum]) {
                    minimum = j;
                }
            }
            int temp = a[i];
            a[i] = a[minimum];
            a[minimum] = temp;
        }
        return a;
    }

}
