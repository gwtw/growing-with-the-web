public class Quicksort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }
    
    private static <T extends Comparable<T>> void sort(T[] array, 
                                                       int left, 
                                                       int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            sort(array, left, pivot - 1);
            sort(array, pivot + 1, right);
        }
    }
    
    private static <T extends Comparable<T>> int partition(T[] array, 
                                                           int left, 
                                                           int right) {
        T pivot = array[right];
        int mid = left;
        for (int i = mid; i < right; i++) {
            if (array[i].compareTo(pivot) <= 0) {
                swap(array, i, mid++);
            }
        }
        swap(array, right, mid);
        return mid;
    }
    
    private static <T extends Comparable<T>> void swap(T[] array, 
                                                       int i1, 
                                                       int i2) {
        if (i1 != i2) {
            T temp = array[i1];
            array[i1] = array[i2];
            array[i2] = temp;
        }
    }
    
    
    
    // Random pivot implementation below
    
    private static Random random = new Random();

    public static <T extends Comparable<T>> void randomSort(T[] array) {
        randomSort(array, 0, array.length - 1);
    }
    
    private static <T extends Comparable<T>> void randomSort(T[] array, 
                                                            int left, 
                                                            int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            randomSort(array, left, pivot - 1);
            randomSort(array, pivot + 1, right);
        }
    }
    
    private static <T extends Comparable<T>> int randomPartition(T[] array, 
                                                                 int left, 
                                                                 int right) {
        int pivot = left + random.nextInt(right - left);
        swap(array, right, pivot);
        return partition(array, left, right);
    }
}
