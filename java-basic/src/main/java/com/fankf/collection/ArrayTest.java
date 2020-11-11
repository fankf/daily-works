package com.fankf.collection;

/**
 * fankunfeng
 * 2020-11-06 08:31
 * <p>
 * <p>
 * 2.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Node[] nodes = new Node[3];
        nodes[0] = new Node(1,0);
        nodes[1] = new Node(3,1);
        nodes[2] = new Node(5,5);

        System.out.println(nodes);
    }
}


class Node {
    int prefix;
    int exponent;

    Node(int prefix, int exponent) {
        this.exponent = exponent;
        this.prefix = prefix;
    }
}
