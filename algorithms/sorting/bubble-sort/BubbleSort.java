public class BubbleSort {
    public static void sortFor(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public static void sortWhile(int[] array) {
        int unsortedBelow = array.length;
        do {
            int lastSwap = 0;
            for (int i = 1; i < unsortedBelow; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i, i - 1);
                    lastSwap = i;
                }
            }
            unsortedBelow = lastSwap;
        } while (unsortedBelow != 0);
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
