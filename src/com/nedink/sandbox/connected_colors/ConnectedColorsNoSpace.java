package com.nedink.sandbox.connected_colors;

import java.util.Arrays;
import java.util.Random;

public class ConnectedColorsNoSpace {

    public static void main(String[] args) {

        int[][] area = new int[5][5];

        Random r = new Random();

        for (int i = 0; i < area.length; ++i) {
            for (int j = 0; j < area[i].length; ++j) {
                area[i][j] = r.nextInt(3);
            }
        }

        for (int[] i : area)
            System.out.println(Arrays.toString(i));

        System.out.println("maximum area: " + maximumColor(area));
    }

    private static int maximumColor(int[][] area) {

        int max = 0;

        int current = area[0][0];

        for (int r = 0; r < area.length; ++r) {
            for (int c = 0; c < area[r].length; ++c) {
                if (area[r][c] == current) {

                }
            }
        }

        return max;
    }

}
