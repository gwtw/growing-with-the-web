package com.growingwiththeweb.algorithms.sorting;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Ignore;

@Ignore
public class MergeSortNaturalTest extends BaseSortTest {
    protected void sort(Integer[] array) {
        Queue<Integer> input = new LinkedList<Integer>();
        for (int i = 0; i < array.length; i++) {
            input.offer(array[i]);
        }
        Queue<Integer> output = MergeSortNatural.sort(input);
        for (int i = 0; i < array.length; i++) {
            array[i] = output.poll();
        }
    }
}
