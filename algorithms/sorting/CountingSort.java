package algorithms.sorting;

public class CountingSort {
    public static void sort(int[] array, int maxValue) {
        int[] buckets = new int[maxValue + 1];

        for (int i = 0; i < array.length; i++) {
            buckets[array[i]]++;
        }

        int sortedIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                array[sortedIndex++] = i;
                buckets[i]--;
            }
        }
    }
}
