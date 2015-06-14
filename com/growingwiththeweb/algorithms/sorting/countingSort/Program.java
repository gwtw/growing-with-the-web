package com.growingwiththeweb.algorithms.sorting.countingsort;

public class Program {
    public static void main(String[] args) {
        int[] sorted = { 1, 2, 4, 6, 9, 9 };
        int[] array = { 9, 6, 2, 9, 1, 4 };
        CountingSort.sort(array, 9);

        for (int i = 0; i < array.length; i++) {
            assert array[i] == sorted[i];
        }

        System.out.println("Tests passed");
      }
}
