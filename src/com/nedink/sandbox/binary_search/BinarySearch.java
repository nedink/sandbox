package com.nedink.sandbox.binary_search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    static int callStackLength = 0;

    public static void main(String[] args) {

        int length = 100000;
        int[] arr = new int[length];
        for (int i = 0; i < length; ++i)
            arr[i] = new Random().nextInt(length);

        Arrays.sort(arr);

        // --------------------------------------------------

        int val = new Random().nextInt(length);

        System.out.println("Recursive: ");
        System.out.println("  location of " + val + ": " + binarySearch(arr, 0, length, val));
        System.out.println("  call stack: " + callStackLength);

        // --------------------------------------------------

        callStackLength = 0;

        System.out.println();

        System.out.println("Iterative: ");
        System.out.println("  location of " + val + ": " + binarySearchIter(arr, 0, length, val));
        System.out.println("  call stack: " + callStackLength);

        // --------------------------------------------------

        System.out.println();
    }

    private static int binarySearch(int[] arr, int from, int to, int val) {

        callStackLength++;

        if (to - from < 1)
            return -1;

        int midpoint = (to - from) / 2 + from;
        int midval = arr[midpoint];

        if (val < midval)
            return binarySearch(arr, from, midpoint, val);

        if (val > midval)
            return binarySearch(arr, midpoint + 1, to, val);

        return midpoint;
    }

    private static int binarySearchIter(int[] arr, int from, int to, int val) {

        while (to - from > 0) {

            callStackLength++;

            int midpoint = (to - from) / 2 + from;
            int midval = arr[midpoint];

            if (val < midval)
                to = midpoint;
            else if (val > midval)
                from = midpoint + 1;
            else
                return midpoint;
        }

        return -1;
    }
}
