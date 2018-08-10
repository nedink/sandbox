package com.nedink.sandbox.two_egg;

import java.util.Random;

public class TwoEgg {

    public static void main(String[] args) {

        int[] trials;
        int max;
        float avg;

        // binary ------------------------------

        trials = new int[1000];

        for (int i = 0; i < trials.length; ++i) {
            int eggFloor = new Random().nextInt(100);
            trials[i] = getDropsBin(eggFloor);
        }

        avg = 0;
        max = 0;
        for (int i : trials) {
            avg += i;
            if (i > max) max = i;
        }
        avg /= trials.length;

        System.out.println("average drops (binary): " + avg);
        System.out.println("most drops (binary): " + max);

        // tens ------------------------------

        trials = new int[1000];

        for (int i = 0; i < trials.length; ++i) {
            int eggFloor = new Random().nextInt(100);
            trials[i] = getDropsTen(eggFloor);
        }

        avg = 0;
        max = 0;
        for (int i : trials) {
            avg += i;
            if (i > max) max = i;
        }
        avg /= trials.length;

        System.out.println("average drops (ten at a time): " + avg);
        System.out.println("most drops (ten at a time): " + max);

        // n minus one ------------------------------

        trials = new int[1000];

        for (int i = 0; i < trials.length; ++i) {
            int eggFloor = new Random().nextInt(100);
            trials[i] = getDropsNMinusOne(eggFloor);
        }

        avg = 0;
        max = 0;
        for (int i : trials) {
            avg += i;
            if (i > max) max = i;
        }
        avg /= trials.length;

        System.out.println("average drops (n minus one): " + avg);
        System.out.println("most drops (n minus one): " + max);
    }

    private static int getDropsBin(int eggFloor) {
        int drops = 0;
        int eggs = 2;
        int min = 0;
        int max = 100;
        int dropFloor = min;

        while (eggs > 1) {
            // drop egg
            dropFloor += (max - min) / 2 > 0 ? (max - min) / 2 : 1;
//            System.out.println("drop floor: " + dropFloor);
            if (eggFloor < dropFloor) {
                // egg breaks
//                System.out.println("> egg breaks!");
                --eggs;
                max = dropFloor;
                dropFloor = min;
            }
            else {
                min = dropFloor;
            }
            ++drops;
        }

        while (eggs > 0) {
            ++dropFloor;
//            System.out.println("drop floor: " + dropFloor);
            if (eggFloor < dropFloor) {
                // egg breaks
                --eggs;
            }
            ++drops;
        }

        return drops;
    }

    private static int getDropsTen(int eggFloor) {
        int drops = 0;
        int eggs = 2;
        int min = 0;
        int dropFloor = min;

        while (eggs > 1) {
            // drop egg
            dropFloor += 10;
            if (eggFloor < dropFloor) {
                // egg breaks
                --eggs;
                dropFloor = min;
            }
            else {
                min = dropFloor;
            }
            ++drops;
        }

        while (eggs > 0) {
            ++dropFloor;
            if (eggFloor < dropFloor) {
                // egg breaks
                --eggs;
            }
            ++drops;
        }

        return drops;
    }

    static int getDropsNMinusOne(int eggFloor) {
        int drops = 0;
        int dropFloor = 0;
        int step = 14;

        while (true) {
            // step drop floor
            dropFloor += step;
            if (step > 1) --step;
            // drop egg
            if (eggFloor < dropFloor) {
                // egg breaks
                break;
            }
            ++drops;
        }

        dropFloor -= step;

        while (true) {
            // drop egg
            if (eggFloor < dropFloor++) {
                break;
            }
            ++drops;
        }

        return drops;
    }

}
