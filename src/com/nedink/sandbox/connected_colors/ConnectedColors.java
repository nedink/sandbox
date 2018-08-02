package com.nedink.sandbox.connected_colors;

import java.util.*;

public class ConnectedColors {

    static int[][] area;
    static Map<Integer, Set<Integer>> visited;
    static {
        Random r = new Random();
        area = new int[5][5];
        for (int i = 0; i < area.length; ++i) {
            for (int j = 0; j < area[i].length; ++j) {
                area[i][j] = r.nextInt(3);
            }
        }
    }

    // debug
    static int call = 1;
    static Map<Integer, Map<Integer, Integer>> visitCount = new HashMap<>();
    static {
        for (int i = -1; i <= area.length; ++i) {
            visitCount.put(i, new HashMap<>());
            for (int j = -1; j <= area[0].length; ++j) {
                visitCount.get(i).put(j, 0);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("\n");
        for (int[] row : area)
            System.out.println(Arrays.toString(row));

        int max = 0;

        visited = new HashMap<>();

        // O(n)
        for (int r = 0; r < area.length; ++r) {
            for (int c = 0; c < area[r].length; ++c) {

                int dfs = 0;

                // O(n)
                if (!visited.computeIfAbsent(r, k -> new HashSet<>()).contains(c))
                    dfs = dfs(area[r][c], r, c);

                max = dfs > max ? dfs : max;
            }
        }

        System.out.println("\n\nmax: " + max);

    }

    static int dfs(int val, int row, int col) {

        int thisVal = area[row][col];
        visited.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        int total = 1;

        // ^
        if (row - 1 >= 0 && area[row - 1][col] == val && !visited.computeIfAbsent(row - 1, k -> new HashSet<>()).contains(col))
            total += dfs(thisVal, row - 1, col);

        // V
        if (row + 1 < area.length && area[row + 1][col] == val && !visited.computeIfAbsent(row + 1, k -> new HashSet<>()).contains(col))
            total += dfs(thisVal, row + 1, col);

        // <
        if (col - 1 >= 0 && area[row][col - 1] == val && !visited.computeIfAbsent(row, k -> new HashSet<>()).contains(col - 1))
            total += dfs(thisVal, row, col - 1);

        // >
        if (col + 1 < area[row].length && area[row][col + 1] == val && !visited.computeIfAbsent(row, k -> new HashSet<>()).contains(col + 1))
            total += dfs(thisVal, row, col + 1);

        // debug
        System.out.print("\n" + call++ + ": dfs call   (r: " + row + ", c: " + col + ")" + "   total: " + total + "   visited: " +
                visitCount.get(row).put(col, visitCount.get(row).get(col) + 1)
        );

        return total;
    }

//    static int dfs(int val, int row, int col) {
//
//        int thisVal;
//        int total = 0;
//
//        if (    row >= 0 &&
//                col >= 0 &&
//                row < area.length &&
//                col < area[row].length &&
//                (thisVal = area[row][col]) == val &&
//                !visited.computeIfAbsent(row, k -> new HashSet<>()).contains(col)) {
//
//            visited.get(row).add(col);
//
//            total = 1;
//
//            // up
//                total += dfs(thisVal, row - 1, col);
//
//            // down
//                total += dfs(thisVal, row + 1, col);
//
//            // left
//                total += dfs(thisVal, row, col - 1);
//
//            // right
//                total += dfs(thisVal, row, col + 1);
//        }
//
//        // debug
//        System.out.print("\n" + call++ + ": dfs call   (r: " + row + ", c: " + col + ")" + "   total: " + total + "   visited: " +
//                visitCount.get(row).put(col, visitCount.get(row).get(col) + 1)
//        );
//
//        return total;
//    }
}
