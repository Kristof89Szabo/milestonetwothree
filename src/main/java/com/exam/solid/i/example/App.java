package com.exam.solid.i.example;

public class App {

    public static void main(String[] args) {

        RotationTree tree = new BalancedTree();

        tree.insert();
        tree.delete();
        tree.traverse();
        tree.leftRotation();
        tree.rightRotation();

        Tree tree2 = new BinarySearchTree();

        tree2.insert();
        tree2.delete();
        tree2.traverse();

		// if leftRotation and rightRotation would be in Tree interface (binary search does not have these normally)
		// that would be called "fat interface" and it would violate Interface segregation principle.-> Design smell

    }
}
