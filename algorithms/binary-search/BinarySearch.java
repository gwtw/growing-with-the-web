public class BinarySearch {
    public static boolean search(int[] sortedArray, int value) {
        return search(sortedArray, value, 0, sortedArray.length - 1);
    }
    
    private static boolean search(int[] sortedArray, int value, int min, int max) {
        if (max < min)
            return false;
        else {
            int mid = (min + max) / 2;

            if (sortedArray[mid] > value)
                return search(sortedArray, value, min, mid-1);
            else if (sortedArray[mid] < value)
                return search(sortedArray, value, mid+1, max);
            else
                return true;
        }
    }
}
