package com.nedink.sandbox.connected_colors;

import java.util.Arrays;
import java.util.Random;

public class ConnectedColorsNoSpace {

    static int[][] area;
    static {
        Random r = new Random();

        area = new int[5][5];

        for (int i = 0; i < area.length; ++i) {
            for (int j = 0; j < area[i].length; ++j) {
                area[i][j] = r.nextInt(3);
            }
        }
    }

    public static void main(String[] args) {

        for (int[] i : area)
            System.out.println(Arrays.toString(i));

        int row = 0;
        int col = 0;
        int val = area[row][col];
        int index = 0;
        int max = 0;
        boolean running = true;
        int local = 0;

        while (running) {

            if (area[row][col] != val) {
                local = 0;
                continue;
            }

            // up
            if (row - 1 >= 0) {
                --row;
                continue;
            }

            // down

            // left

            // right
        }
    }
}
