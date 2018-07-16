package com.nedink.sandbox;

public class Node {
    int id;
    Node prev;
    Node next;
    Node(Node prev) {
        this.prev = prev;

        if (prev == null) {
            id = 0;
            return;
        }

        id = prev.id + 1;
    }

    Node spawnNext() {
        return (next = new Node(this));
    }
}
