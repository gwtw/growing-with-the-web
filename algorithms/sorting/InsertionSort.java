package algorithms.sorting;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int item = array[i];
            int indexHole = i;
            while (indexHole > 0 && array[indexHole - 1] > item) {
                array[indexHole] = array[--indexHole];
            }
            array[indexHole] = item;
        }
    }
}
