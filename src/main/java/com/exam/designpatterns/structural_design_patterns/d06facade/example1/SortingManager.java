package com.exam.designpatterns.structural_design_patterns.d06facade.example1;

public class SortingManager {

    private Sorter bubbleSort;
    private Sorter quickSort;
    private Sorter mergeSort;

    public SortingManager() {
        this.bubbleSort = new BubbleSort();
        this.quickSort = new QuickSort();
        this.mergeSort = new MergeSort();
    }

    public void doBubbleSort() {
        this.bubbleSort.sort();
    }

    public void doQuickSort() {
        this.quickSort.sort();
    }

    public void doMergeSort() {
        this.mergeSort.sort();
    }
}
