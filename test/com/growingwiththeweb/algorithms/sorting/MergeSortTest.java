package com.growingwiththeweb.algorithms.sorting;

public class MergeSortTest extends BaseSortTest {
    protected void sort(Integer[] array) {
        Integer[] output = MergeSort.sort(array);
        for (int i = 0; i < output.length; i++) {
            array[i] = output[i];
        }
    }
}
