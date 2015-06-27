package com.growingwiththeweb.algorithms.sorting;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortNatural {
    public static <T extends Comparable<T>> Queue<T> sort(Queue<T> input) {
        Queue<T> output = new LinkedList<T>();
        Queue<T> tempArray1 = new LinkedList<T>();
        Queue<T> tempArray2 = new LinkedList<T>();
        while (input.size() > 0) {
            while (input.size() > 0) {
                merge(input, output, tempArray1);
                merge(input, output, tempArray2);
            }
            while (tempArray1.size() > 0 || tempArray2.size() > 0) {
                merge(tempArray1, tempArray2, output);
                merge(tempArray1, tempArray2, input);
            }
        }
        return output;
    }

    public static <T extends Comparable<T>> void merge(Queue<T> left, Queue<T> right, Queue<T> output) {
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
