package com.growingwiththeweb.algorithms.sorting;

public class MergeSort {
    public static Integer[] sort(Integer[] array) {
        if (array.length <= 1)
            return array;

        int middle = array.length / 2;
        Integer[] left = new Integer[middle];
        Integer[] right = new Integer[array.length - middle];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[i + left.length];
        }

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    public static Integer[] merge(Integer[] left, Integer[] right) {
        Integer[] result = new Integer[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] <= right[rightIndex]) {
                    result[resultIndex++] = left[leftIndex++];
                } else {
                    result[resultIndex++] = right[rightIndex++];
                }
            } else if (leftIndex < left.length) {
                result[resultIndex++] = left[leftIndex++];
            } else if (rightIndex < right.length) {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        return result;
    }
}
