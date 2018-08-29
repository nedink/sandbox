package com.nedink.sandbox.animation;

public class Spinner {

    public static void main(String[] args) throws InterruptedException {
        char[] frames = {'|', '/', '-', '\\'};
        int index = 0;

        while (true) {
            Thread.sleep(100);
            System.out.print('\r');
            System.out.print(frames[index++ % frames.length] + " " + index % frames.length);
        }
    }
}
