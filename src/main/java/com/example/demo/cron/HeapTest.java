package com.example.demo.cron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class HeapTest {
    private static Node root;
    private static Node cursor;

    public static void main(String[] args) {
        ArrayList<Node> arr = new ArrayList<>();
        Node root = null;
        arr.add(new Node(4,null,null));
        arr.add(new Node(1,null,null));
        arr.add(new Node(3,null,null));
        arr.add(new Node(2,null,null));
        arr.add(new Node(5,null,null));

        sort(arr);
        System.out.println(arr);
    }

//    private void init(){
//        ArrayList<Node> arr = new ArrayList<>();
//        root = null;
//        arr.add(new Node(4,null,null));
//        arr.add(new Node(1,null,null));
//        arr.add(new Node(3,null,null));
//        arr.add(new Node(2,null,null));
//        arr.add(new Node(5,null,null));
//
//
//    }

    public static void sort(ArrayList<Node> arr){
//        root = arr.get(0);
//        cursor = root;
        for (int i = 0; i < arr.size(); i++) {
            heapify(arr.get(i));
        }
    }
    private static void heapify(Node cursor){

        Node parent = cursor;

        Node maxNode = Max(parent,cursor.left,cursor.right);

        if (parent != maxNode){
            swap(parent,maxNode);
            cursor = maxNode;
            heapify(cursor);
        }
    }

    private static Node Max(Node a, Node b, Node c){
        ArrayList<Node> linkedList = new ArrayList<>();
        linkedList.add(a);
        linkedList.add(b);
        linkedList.add(c);

        linkedList.sort(new Comparator<>() {
            @Override
            public int compare(Node c1, Node c2) {
                return c2.value - c1.value;
            }
        });
        Node first = linkedList.get(0);
        return first;
    }

    private static void swap(Node a, Node b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

}

