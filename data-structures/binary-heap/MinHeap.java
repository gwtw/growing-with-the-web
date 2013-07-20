import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
	private ArrayList<T> list;

	public MinHeap() {
		this(0);
	}
	
	public MinHeap(int size) {
		list = new ArrayList<T>(size);
	}
	
	public MinHeap(ArrayList<T> items) {
		list = items;
		buildHeap();
	}
	
	public void insert(T item) {
		int i = list.size();
		list.add(item);
		int parent = parent(i);
		while (parent != i && list.get(i).compareTo(list.get(parent)) < 0) {
			swap(i, parent);
			i = parent;
			parent = parent(i);
		}
	}
	
	public T extractMin() {
		if (list.size() == 0)
			return null;
		if (list.size() == 1)
			return list.remove(0);
		T min = list.get(0);
		T last = list.remove(list.size() - 1);
		list.set(0, last);
		heapify(0);
		return min;
	}
	
	public T min() {
		return list.get(0);
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public int size() {
		return list.size();
	}
	
	public void print() {
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + ", ");
		System.out.println();
	}
	
	private void buildHeap() {
	    for (int i = (int)(list.size() / 2); i >= 0; i--)
	    	heapify(i);
	}

	private void heapify(int i) {
	    int left = left(i);
	    int right = right(i);
	    int small = i;
	    if (left < list.size() && list.get(left).compareTo(list.get(i)) < 0)
	        small = left;
	    if (right < list.size() && list.get(right).compareTo(list.get(small)) < 0)
	    	small = right;
	    if (small != i) {
	        swap(i, small);
	        heapify(small);
	    }
	}

	private void swap(int i1, int i2) {
	    T temp = list.get(i1);
	    list.set(i1, list.get(i2));
	    list.set(i2, temp);
	}
	
	private int parent(int i) {
		return i / 2;
	}
	
	private int left(int i) {
		return 2 * i;
	}
	
	private int right(int i) {
		return 2 * i + 1;
	}
}
