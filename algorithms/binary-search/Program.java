import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 5, 6, 7, 9 };
        
        assert !BinarySearch.search(array, 0);
        assert BinarySearch.search(array, 1);
        assert BinarySearch.search(array, 2);
        assert BinarySearch.search(array, 3);
        assert !BinarySearch.search(array, 4);
        assert BinarySearch.search(array, 5);
        assert BinarySearch.search(array, 6);
        assert BinarySearch.search(array, 7);
        assert !BinarySearch.search(array, 8);
        assert BinarySearch.search(array, 9);
        assert !BinarySearch.search(array, 10);

  	    System.out.println("Tests passed");
    }
}
