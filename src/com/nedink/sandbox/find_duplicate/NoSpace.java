package com.nedink.sandbox.find_duplicate;

import java.util.Arrays;
import java.util.Random;

public class NoSpace {

    public static void main(String[] args) {

        int n = 50;
        Random r = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i)
            array[i] = r.nextInt(n - 1);

        System.out.println("array: " + Arrays.toString(array));

        // ---------------------------------------------


    }
}
