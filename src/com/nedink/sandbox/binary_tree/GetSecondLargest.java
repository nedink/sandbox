package com.nedink.sandbox.binary_tree;

import java.util.Random;

public class GetSecondLargest {

    public static void main(String[] args) {

        Random r = new Random();

        BinaryTreeNode root = new BinaryTreeNode(r.nextInt(100));
        root.addLeft(new BinaryTreeNode(r.nextInt(100)));
        root.addRight(new BinaryTreeNode(r.nextInt(100)));
        root.getLeft().addLeft(new BinaryTreeNode(r.nextInt(100)));
        root.getLeft().addRight(new BinaryTreeNode(r.nextInt(100)));
        root.getRight().addLeft(new BinaryTreeNode(r.nextInt(100)));
        root.getRight().addRight(new BinaryTreeNode(r.nextInt(100)));


    }

    static int secondLargest() {

        return 0;
    }
}
