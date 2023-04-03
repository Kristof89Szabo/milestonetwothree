package com.exam.designpatterns.structural_design_patterns.d06facade.example1;

public class App {

    public static void main(String[] args) {
        SortingManager manager = new SortingManager();
        manager.doBubbleSort();
        manager.doMergeSort();
        manager.doQuickSort();
    }
}
