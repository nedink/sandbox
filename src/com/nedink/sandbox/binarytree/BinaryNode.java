package com.nedink.sandbox.binarytree;

import java.util.ArrayList;
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

    public static class RenderNode extends BinaryNode {
        public int x;
        public int y;
        public RenderNode(BinaryNode parent) {
            super(parent);
        }
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
