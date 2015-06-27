package com.growingwiththeweb.algorithms.sorting;

public class BubbleSortOptimised {
    public static void sort(Integer[] array) {
        int unsortedBelow = array.length;
        while (unsortedBelow != 0) {
            int lastSwap = 0;
            for (int i = 1; i < unsortedBelow; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i, i - 1);
                    lastSwap = i;
                }
            }
            unsortedBelow = lastSwap;
        }
    }

    private static void swap(Integer[] array, int a, int b) {
        Integer temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
