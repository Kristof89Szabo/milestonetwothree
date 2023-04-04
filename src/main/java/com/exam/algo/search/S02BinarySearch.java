package com.exam.algo.search;

public class S02BinarySearch {

    public static void main(String[] args) {


        /*
        O(loGn)

        - Data must be sorted!
        - Minden iterációnál a felénél nézzük meg az arraynek, hogy  a felette van -e a keresett dolog vagy alatta.
            Igy tudjuk eliminálni akár a fele array-t.

         Array: 3,11,21,29,41,54,61,78,110,127
         Keressuk meg a 78-at.
         - Megfelezzük az Array-t.   9/2 = 4.5 -> 4  lesz a mid position of array,
         A 4. indexen 41 van, szóval 78 nagyobb mint mint 41,   41 ig bezárólag ki tudjuk zárni a keresések közül.
           

         */

        int[] intArr = {1, 2, 3, 4, 5, 6};
        int search = 6;
        System.out.println(binarySearh(intArr, search));

    }

    private static int binarySearh(int[] intArr, int x) {
        int p = 0;
        int r = intArr.length - 1;

        while (p <= r) {
            int q = (p + r) / 2;
            if (intArr[q] == x) {
                return q;
            }
            if (intArr[q] > x) {
                r = q - 1;
            } else {
                p = q + 1;
            }
        }
        return -1;
    }

}
