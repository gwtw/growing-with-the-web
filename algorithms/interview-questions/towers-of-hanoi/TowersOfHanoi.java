import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TowersOfHanoi {
    private final int NUMBER_OF_TOWERS = 3;
    private ArrayList<Stack<Integer>> towers = new ArrayList<Stack<Integer>>();

    public TowersOfHanoi(int size) {
        for (int i = 0; i < NUMBER_OF_TOWERS; i++) {
            towers.add(new Stack<Integer>());
        }
        for (int i = size; i > 0; i--) {
            towers.get(0).push(i);
        }
    }

    public void moveTower(int disk, int source, int destination, int spare) {
        if (disk == 1) {
            // Base case, move the smallest disk
            towers.get(destination).push(towers.get(source).pop());
        } else {
            // Move all but largest disk to spare
            moveTower(disk - 1, source, spare, destination);

            // Move the largest disk to destination
            towers.get(destination).push(towers.get(source).pop());
            
            // Move the rest of the tower back on top of the largest
            moveTower(disk - 1, spare, destination, source);
        }
    }

    public void print() {
        for (int i = 0; i < NUMBER_OF_TOWERS; i++) {
            Iterator<Integer> iter = towers.get(i).iterator();
            System.out.print("Tower " + (i + 1) + ": ");
            while (iter.hasNext()){
                System.out.print(iter.next());
            }
            System.out.println();
        }
    }
}
