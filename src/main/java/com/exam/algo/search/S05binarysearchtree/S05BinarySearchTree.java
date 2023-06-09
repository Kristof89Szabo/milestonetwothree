package com.exam.algo.search.S05binarysearchtree;

public class S05BinarySearchTree {

    private Node root;

    public void insert(int key, String value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;

            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) { // It`s parent is the leaf node.
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }

    }

    public Node findMin(){
        Node current = root;
        Node last = null;


        while(current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node findMax(){
        Node current = root;
        Node last = null;


        while(current != null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

}
