package com.nedink.sandbox.sandbox;

public class PrintStuff {
    public static void main(String[] args) {
        String string = "1 \n2 \n3 \n";

        System.out.print(string);

        for (String s : string.split("\n")) {
            System.out.print(s);
        }
    }
}
