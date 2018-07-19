package com.nedink.sandbox.sandbox;

public class Sandbox {

    public static void main(String[] args) {

        // forEach across two lists of same length
        /*
        List<String> list1 = Arrays.asList("hi", "bye", "yo");
        List<String> list2 = Arrays.asList("a", "b", "c");
        list1.forEach(item -> System.out.println(list2.get(list1.indexOf(item))));
        */

        Node n0 = new Node(null);
        Node n1 = new Node(n0);
        Node n2 = new Node(n1, null);
//        Node n2 = n1;

        System.out.println(n1);
        System.out.println(n2);

        n2.next = new Node(n2);
        System.out.println(n1.next);
        System.out.println(n2.next);

//        System.out.println(n1.id);
//        System.out.println(n2.id);
//        System.out.println(n3.id);
//        System.out.println();
//        System.out.println(n2.id);
    }

    static void doThing(Node n) {
        n.next = new Node(n);
    }
}
