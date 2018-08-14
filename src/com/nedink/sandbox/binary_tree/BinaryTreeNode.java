package com.nedink.sandbox.binary_tree;

public class BinaryTreeNode {

    private BinaryTreeNode left, right;

    private int value;

    public BinaryTreeNode(int value) {
        value = value;
    }

    void addLeft(BinaryTreeNode left) {
        this.left = left;
    }

    void addRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

}
