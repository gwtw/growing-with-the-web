public class Program {
    public static void main(String[] args) {
        TestQuicksortFixedPivot();
        TestQuicksortRandomPivot();

		System.out.println("Tests passed");
  	}
      
    private static void TestQuicksortFixedPivot() {
        int[] sorted = { 1, 2, 4, 6, 9, 9 };

        int[] array = { 9, 6, 2, 9, 1, 4 };
        Quicksort.sort(array);

    	for (int i = 0; i < array.length; i++) {
			assert array[i] == sorted[i];
		}
    }
      
    private static void TestQuicksortRandomPivot() {
        int[] sorted = { 1, 2, 4, 6, 9, 9 };

        int[] array = { 9, 6, 2, 9, 1, 4 };
        Quicksort.randomSort(array);

    	for (int i = 0; i < array.length; i++) {
			assert array[i] == sorted[i];
		}
    }
}
