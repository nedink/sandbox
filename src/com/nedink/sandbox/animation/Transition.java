package com.nedink.sandbox.animation;

public class Transition {
    public static void main(String[] args) throws InterruptedException {

        float dist = 50;

        // out
        do {
            Thread.sleep(50);
            for (int i=0; i++<dist;)
                System.out.print('#');
//            System.out.println();
        } while ((dist *= 0.8) > 0.5f);
        System.out.println();

        // in
        dist = 1;
        do {
            Thread.sleep(50);
            for (int i=0; i++<dist;)
                System.out.print('#');
//            System.out.println();
        } while ((dist *= 1.2) < 46);
        System.out.println();
    }
}
