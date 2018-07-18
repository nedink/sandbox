package com.nedink.sandbox.binarytree;

import java.util.Scanner;

public class BinaryTree {

    public static BinaryNode node;

    public static void main(String[] args) {
        node = new BinaryNode(null);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {

//            System.out.println(node.printTree());
//            BinaryNode.traverseDFS(node);
//            System.out.println("max left: " + BinaryNode.getMaxLeft(node));
            System.out.println(BinaryNode.printMap(node));

            input = scanner.next();
            switch (input) {
                case "l":
                    if (node.spawnLeft())
                        System.out.println("spawned left");
                    else
                        System.out.println("child exists");
                    node = node.leftChild;
                    break;
                case "r":
                    if (node.spawnRight())
                        System.out.println("spawned right");
                    else
                        System.out.println("child exists");
                    node = node.rightChild;
                    break;
                case "b":
                    if (node.parent == null) {
                        System.out.println("already at root");
                        break;
                    }
                    node = node.parent;
                    if (node.parent == null)
                        System.out.println("at root");
                    break;
                case "q":
                    System.exit(1);
                    break;
                default:
                    System.out.println("unrecognized command");
                    break;
            }
        }
    }

    static void printTree() {

    }
}
