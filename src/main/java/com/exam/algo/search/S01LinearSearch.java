package com.exam.algo.search;

public class S01LinearSearch {

    public static void main(String[] args) { // O(n)
        int[] intArr = {1, 2, 3, 4, 5, 6};
        int search = 4;
        System.out.println(linearSearch(intArr, search));
    }

    private static int linearSearch(int[] intArr, int search) {
        int retNum = -1;

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] == search) {
                retNum = i;
                break;
            }
        }
        return retNum;
    }

}
