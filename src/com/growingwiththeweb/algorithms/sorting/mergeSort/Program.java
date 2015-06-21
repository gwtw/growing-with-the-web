package com.growingwiththeweb.algorithms.sorting.mergesort;

public class Program {
    public static void main(String[] args) {
        int[] sorted = { 1, 2, 4, 6, 9, 9 };

        int[] array = { 9, 6, 2, 9, 1, 4 };
        int[] mergedArray = mergeSort(array);

        for (int i = 0; i < mergedArray.length; i++) {
            assert mergedArray[i] == sorted[i];
        }

        System.out.println("Tests passed");
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;

        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[i + left.length];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
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
