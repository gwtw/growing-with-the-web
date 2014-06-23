import java.util.LinkedList;
import java.util.Queue;

public class Program {
	public static void main(String[] args) {
		int[] sorted = { 1, 2, 4, 6, 9, 9 };

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(9);
		queue.add(6);
		queue.add(2);
		queue.add(9);
		queue.add(1);
		queue.add(4);
		queue = naturalMergeSort(queue);

		for (int i = 0; i < sorted.length; i++) {
			assert queue.poll() == sorted[i];
		}

		System.out.println("Tests passed");
	}

	public static <T extends Comparable<T>> Queue<T> naturalMergeSort(Queue<T> input) {
	    Queue<T> output = new LinkedList<T>();
	    Queue<T> tempArray1 = new LinkedList<T>();
	    Queue<T> tempArray2 = new LinkedList<T>();
	    while (input.size() > 0) {
	        while (input.size() > 0) {
	            while (input.size() > 0) {
	                naturalMerge(input, output, tempArray1);
	                naturalMerge(input, output, tempArray2);
	            }
	            while (tempArray1.size() > 0 || tempArray2.size() > 0) {
	                naturalMerge(tempArray1, tempArray2, output);
	                naturalMerge(tempArray1, tempArray2, input);
	            }
	        }
	    }
	    return output;
	}

	public static <T extends Comparable<T>> void naturalMerge(Queue<T> left, Queue<T> right, Queue<T> output) {
	    T prevLeft = null;
	    T prevRight = null;
	    while ((left.size() > 0 && (prevLeft == null || prevLeft.compareTo(left.peek()) <= 0)) ||
	           (right.size() > 0 && (prevRight == null || prevRight.compareTo(right.peek()) <= 0))) {

	        if (right.size() == 0 || (left.size() > 0 && left.peek().compareTo(right.peek()) <= 0)) {
	            prevLeft = left.poll();
	            output.add(prevLeft);
	        } else {
	            prevRight = right.poll();
	            output.add(prevRight);
	        }
	    }
	}
}
