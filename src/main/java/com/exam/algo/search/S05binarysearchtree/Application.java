package com.exam.algo.search.S05binarysearchtree;

public class Application {

    public static void main(String[] args) {
        S05BinarySearchTree tree = new S05BinarySearchTree();
        tree.insert(10, "ten");
        tree.insert(20, "twenty");
        tree.insert(15, "fifteen");
        tree.insert(9, "nine");

        System.out.println(tree.findMin().key);
        System.out.println(tree.findMax().key);
    }

}
