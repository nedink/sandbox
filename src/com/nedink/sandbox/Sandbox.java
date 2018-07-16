package com.nedink.sandbox;

public class Sandbox {

    public static void main(String[] args) {

        // forEach across two lists of same length
        /*
        List<String> list1 = Arrays.asList("hi", "bye", "yo");
        List<String> list2 = Arrays.asList("a", "b", "c");
        list1.forEach(item -> System.out.println(list2.get(list1.indexOf(item))));
        */

        Node n1 = new Node(null);
//        Node n2 = n1.spawnNext();
//        Node n3 = n2.spawnNext();
        n1 = n1.spawnNext();
        n1 = n1.spawnNext();

        System.out.println(n1.id);


//        System.out.println(n1.id);
//        System.out.println(n2.id);
//        System.out.println(n3.id);
//        System.out.println();
//        System.out.println(n2.id);
    }
}
