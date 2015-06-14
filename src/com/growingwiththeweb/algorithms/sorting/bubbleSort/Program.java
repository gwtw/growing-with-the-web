package com.growingwiththeweb.algorithms.sorting.bubblesort;

public class Program {
    public static void main(String[] args) {
        int[] sorted = { 1, 2, 4, 6, 9, 9 };

        int[] array1 = { 9, 6, 2, 9, 1, 4 };
        int[] array2 = { 9, 6, 2, 9, 1, 4 };
        BubbleSort.sortFor(array1);
        BubbleSort.sortWhile(array2);

        for (int i = 0; i < array1.length; i++) {
            assert array1[i] == sorted[i];
        }
        for (int i = 0; i < array2.length; i++) {
            assert array2[i] == sorted[i];
        }

        System.out.println("Tests passed");
      }
}
