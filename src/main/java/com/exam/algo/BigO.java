package com.exam.algo;

public class BigO {

    public static void main(String[] args) {
        linear(); // Single loop -> O(n)
        constant(); // One single operation. -> O(1)
        quadratic(); // Loop inside of loop -> O(n2)
        cubic(); // 3 nested loop.  ->  O(n3)
        // exponential(); // -> O(nn)

    }

    public static void linear() {
        int[] intArr = {1, 2, 3, 4, 5, 6};
        int counter = 0;

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }

    private static void constant() {
        int[] intArr = {1, 2, 3, 4, 5, 6};
        int ind = 5;

        int findNum = intArr[ind];
        System.out.println(findNum);
    }

    private static void quadratic() {
        // countDuplicates
        int[] intArr = {1, 2, 3, 4, 5, 6};
        int[] intArr2 = {5, 6, 7, 8, 9};

        int count = 0;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr2.length; j++) {
                if (intArr[i] == intArr2[i]) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }


    private static void cubic() {
    }


}
