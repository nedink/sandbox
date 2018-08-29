package com.nedink.sandbox.output_anim;

import java.util.Random;

public class OutputAnim {

    public static void main(String[] args) {

        Random r = new Random();
        int trueIndex = 0;
        int index = 0;

        while (trueIndex++ < 800) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print((char) (r.nextInt(26) + 97));
            if (r.nextInt(10) == 0)
                System.out.print(' ');
            if (r.nextInt(20) == 0)
                System.out.println();
            index++;
        }
    }
}
