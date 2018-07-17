package com.nedink.sandbox.binarytree;

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

    public BinaryNode copy() {
        BinaryNode node = new BinaryNode(this.parent == null ? null : this.parent.copy());
        node.leftChild = node.leftChild == null ? null : node.leftChild.copy();
        node.rightChild = node.rightChild == null ? null : node.rightChild.copy();
        return node;
    }

    public static void traverseDFS(BinaryNode node) {
        while (node.parent != null) node = node.parent;
        List<BinaryNode> checked = new LinkedList<>();

        while(node != null) {
            if (node.leftChild != null && !checked.contains(node.leftChild)) {
//                System.out.println("going left, adding to checked");
                System.out.println("<-");
                node = node.leftChild;
                checked.add(node);
            }
            else if (node.rightChild != null && !checked.contains(node.rightChild)) {
//                System.out.println("going right, adding to checked");
                System.out.println("->");
                node = node.rightChild;
                checked.add(node);
            }
            else {
//                System.out.println("both checked, going up");
                System.out.println("^");
                node = node.parent;
            }
        }

        System.out.println("checked: " + checked.size());
    }

    public String printTree() {



        String out = "";

        // get root
        BinaryNode root = this;
        while (root.parent != null)
            root = root.parent;

        out += "+";

        // get left (horizontal) branch
        List<Integer> colsWithRightChildren = new ArrayList<>();
        int col = 0;
        while (root != null) {

            if (root.rightChild != null)
                colsWithRightChildren.add(col);

            if (root.parent != null)
                out += "-+";

            root = root.leftChild;

            col++;
        }

        out += "\n";

        // draw right (downward) branches
        int last = 0;
        for (Integer i : colsWithRightChildren) {
            for (int j = 1; j < i - last; ++j)
                out += "  ";
            out += "| ";
            last = i;
        }

        out += "\n";

        last = 0;
        for (Integer i : colsWithRightChildren) {
            for (int j = 1; j < i - last; ++j)
                out += "  ";
            out += "+ ";
            last = i;
        }

        // draw left branches, starting with


        return out;
    }

}
