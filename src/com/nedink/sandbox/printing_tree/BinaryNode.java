package com.nedink.sandbox.printing_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryNode {

    public BinaryNode parent;
    public BinaryNode rightChild;
    public BinaryNode leftChild;

    public BinaryNode(BinaryNode parent) {
        this.parent = parent;
    }

    public boolean spawnRight() {
        if (rightChild != null)
            return false;
        rightChild = new BinaryNode(this);
        return true;
    }

    public boolean spawnLeft() {
        if (leftChild != null)
            return false;
        leftChild = new BinaryNode(this);
        return true;
    }

    public static BinaryNode getRoot(BinaryNode node) {
        while (node.parent != null) node = node.parent;
        return node;
    }

    public static class XY {int x; int y; public XY(int x, int y) {this.x = x; this.y = y;}}

    public static String printMap(BinaryNode node) {

        List<List<String>> cellMap = new ArrayList<>();
        cellMap.add(new ArrayList<>());
        cellMap.get(0).add("o");
//        List<StringBuilder> cellMap = new ArrayList<>();
//        cellMap.add(new StringBuilder().append("o"));

        node = BinaryNode.getRoot(node);
        int row = 0, col = 0;
        List<BinaryNode> checked = new LinkedList<>();

        while(node != null) {

//            System.out.println("ROW " + row);

            if (node.leftChild != null && !checked.contains(node.leftChild)) {
                node = node.leftChild;
                checked.add(node);
                col++;
                if (cellMap.get(row).size() <= col) {
//                    cellMap.get(row).add("-o");
                }
                if (cellMap.get(row).size() > col){
//                    if (cellMap.get(row).get(col).equals(" o") || cellMap.get(row).equals(" |")) {
//                        System.out.println("0");
//                    }
                    while (cellMap.get(row).get(col).equals(" o") || cellMap.get(row).get(col).equals(" |")) {
                        // set to |
                        cellMap.get(row).set(col - 1, col - 1 == 0 ? "|" : " |");
                        row++;
                        // new row
                        cellMap.add(new ArrayList<>());
                        cellMap.get(row).add(col - 1 == 0 ? "" : " ");
                        for (int i = 0; i < col - 2; ++i)
                            cellMap.get(row).add("  ");
                        cellMap.get(row).add(col - 1 == 0 ? "|" : " |");
                    }
                    // new row for nodes, fill with space and start at col
                    row++;
                    cellMap.add(new ArrayList<>());
                    cellMap.get(row).add(col - 1 == 0 ? "" : " ");
                    for (int i = 0; i < col - 2; ++i)
                        cellMap.get(row).add("  ");
                    cellMap.get(row).add(col - 1 == 0 ? "o" : " o");

                }
                cellMap.get(row).add("-o");
            }
            else if (node.rightChild != null && !checked.contains(node.rightChild)) {
                node = node.rightChild;
                checked.add(node);
                row++;
                if (cellMap.size() <= row) {
                    // new row for pipes, fill with space and start at col
                    cellMap.add(new ArrayList<>());
                    cellMap.get(row).add(col == 0 ? "" : " ");
                    for (int i = 0; i < col - 1; ++i)
                        cellMap.get(row).add("  ");
                    cellMap.get(row).add(col == 0 ? "|" : " |");
                    // new row for nodes, fill with space and start at col
                    row++;
                    cellMap.add(new ArrayList<>());
                    cellMap.get(row).add(col == 0 ? "" : " ");
                    for (int i = 0; i < col - 1; ++i)
                        cellMap.get(row).add("  ");
                    cellMap.get(row).add(col == 0 ? "o" : " o");
                }
                else {
                    cellMap.get(row).set(col, col == 0 ? "|" : " |");
//                    row++;
                    cellMap.get(row + 1).set(col, col == 0 ? "o" : " o");
                }
            }
            else {
                if (node.parent != null) {
                    if (node == node.parent.leftChild) col--;
                    else row -= 2;
                }
                node = node.parent;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> cellRow : cellMap) {
            for (String cell : cellRow) {
                stringBuilder.append(cell);
            }
            stringBuilder.append("\n");
        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (StringBuilder s : cellMap) {
//            stringBuilder.append(s).append("\n");
//        }

        return stringBuilder.toString();
    }

    public static int getMaxLeft(BinaryNode node) {
        node = getRoot(node);
        List<BinaryNode> checked = new LinkedList<>();
        int max = 0;
        int localMax = 0;
        while(node != null) {
            if (node.leftChild != null && !checked.contains(node.leftChild)) {
                node = node.leftChild;
                if (++localMax > max) max = localMax;
                checked.add(node);
            }
            else if (node.rightChild != null && !checked.contains(node.rightChild)) {
                node = node.rightChild;
                checked.add(node);
            }
            else {
                if (node.parent != null && node == node.parent.leftChild) --localMax;
                node = node.parent;
            }
        }
        return max;
    }

    public static void traverseDFS(BinaryNode node) {

        node = getRoot(node);

        List<BinaryNode> checked = new LinkedList<>();

        while(node != null) {
            if (node.leftChild != null && !checked.contains(node.leftChild)) {
                System.out.println("<-");
                node = node.leftChild;
                checked.add(node);
            }
            else if (node.rightChild != null && !checked.contains(node.rightChild)) {
                System.out.println("->");
                node = node.rightChild;
                checked.add(node);
            }
            else {
                System.out.println("^");
                node = node.parent;
            }
        }

        System.out.println("checked: " + checked.size());
    }

    public String printTree() {

        StringBuilder out = new StringBuilder();



        return out.toString();
    }

}
