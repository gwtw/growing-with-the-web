package com.growingwiththeweb.algorithms.sorting;

public class MergeSortBottomUp {
    public static void sort(Integer[] array) {
        Integer[] workArray = new Integer[array.length];
        int chunkSize = 1;
        while (chunkSize < array.length) {
            int i = 0;
            while (i < array.length - chunkSize) {
                merge(array, i, chunkSize, workArray);
                i += chunkSize * 2;
            }
            chunkSize *= 2;
        }
    }

    public static void merge(Integer[] array, int leftPosition, int chunkSize, Integer[] workArray) {
        int rightPosition = leftPosition + chunkSize;
        int endPosition = Math.min(leftPosition + chunkSize * 2 - 1, array.length - 1);
        int leftIndex = leftPosition;
        int rightIndex = rightPosition;

        for (int i = 0; i <= endPosition - leftPosition; i++) {
            if (leftIndex < rightPosition &&
                    (rightIndex > endPosition ||
                    array[leftIndex] <= array[rightIndex])) {
                workArray[i] = array[leftIndex++];
            } else {
                workArray[i] = array[rightIndex++];
            }
        }

        for (int i = leftPosition; i <= endPosition; i++) {
            array[i] = workArray[i - leftPosition];
        }
    }
}
