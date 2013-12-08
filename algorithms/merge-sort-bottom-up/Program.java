public class Program {
	public static void main(String[] args) {
		int[] sorted = { 1, 2, 4, 6, 9, 9 };

		int[] bottomUpArray = { 9, 6, 2, 9, 1, 4 };
		bottomUpMergeSort(bottomUpArray);

		for (int i = 0; i < bottomUpArray.length; i++) {
			assert bottomUpArray[i] == sorted[i];
		}

		System.out.println("Tests passed");
	}

	public static void bottomUpMergeSort(int[] array) {
		int[] workArray = new int[array.length];
		int chunkSize = 1;
		while (chunkSize < array.length) {
		    int i = 0;
		    while (i < array.length - chunkSize) {
		        bottomUpMerge(array, i, chunkSize, workArray);
		        i += chunkSize * 2;
		    }
		    chunkSize *= 2;
		}
	}

	public static void bottomUpMerge(int[] array, int leftPosition, int chunkSize, int[] workArray) {
	    int rightPosition = leftPosition + chunkSize;
	    int endPosition = Math.min(leftPosition + chunkSize * 2 - 1, array.length - 1);
	    int leftIndex = leftPosition;
	    int rightIndex = rightPosition;

	    for (int i = 0; i <= endPosition - leftPosition; i++) {
	    	if (leftIndex < rightPosition &&
	    			(rightIndex > endPosition ||
	    			array[leftIndex] <= array[rightIndex])) {
	    		workArray[i] = array[leftIndex++];
	    	} else {
	    		workArray[i] = array[rightIndex++];
	    	}
	    }

	    for (int i = leftPosition; i <= endPosition; i++) {
	    	array[i] = workArray[i - leftPosition];
	    }
	}
}
