package com.growingwiththeweb.algorithms.sorting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.Callable;

public abstract class BaseSortTest {
    protected abstract void sort(Integer[] array);

    protected boolean arraysMatch(Integer[] a, Integer[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.out.println("arraysMatch failure");
                System.out.println("a = " + a.toString());
                for (int j = 0; j < a.length; j++) {
                    System.out.print(a[j] + ", ");
                }
                System.out.println("");
                System.out.println("b = " + b.toString());
                for (int j = 0; j < b.length; j++) {
                    System.out.print(b[j] + ", ");
                }
                System.out.println("");
                return false;
            }
        }
        return true;
    }

    protected void testSort(Integer[] input, Integer[] expected) {
        sort(input);
        assertTrue(arraysMatch(input, expected));
    }

    @Test
    public void testSortEmptyArray() {
        testSort(new Integer[] {},
                 new Integer[] {});
    }

    @Test
    public void testSortSmallSortedArray() {
        testSort(new Integer[] {1,2,3,4,5},
                 new Integer[] {1,2,3,4,5});
    }

    @Test
    public void testSortSmallReverseSortedArray() {
        testSort(new Integer[] {5,4,3,2,1},
                 new Integer[] {1,2,3,4,5});
    }

    @Test
    public void testSortSmallSortedArrayWithOnlyNegativeValues() {
        testSort(new Integer[] {-5,-4,-3,-2,-1},
                 new Integer[] {-5,-4,-3,-2,-1});
    }

    @Test
    public void testSortSmallReverseSortedArrayWithOnlyNegativeValues() {
        testSort(new Integer[] {-1,-2,-3,-4,-5},
                 new Integer[] {-5,-4,-3,-2,-1});
    }

    @Test
    public void testSortSmallSortedArrayWithTwoValuesSwapped() {
        testSort(new Integer[] {1,2,5,4,3},
                 new Integer[] {1,2,3,4,5});
    }

    @Test
    public void testSortLargeSortedArray() {
        testSort(new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20},
                 new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
    }

    @Test
    public void testSortLargeReverseSortedArray() {
        testSort(new Integer[] {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0},
                 new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
    }

    @Test
    public void testSortLargeArrayWithTwoValuesSwapped() {
        testSort(new Integer[] {0,1,2,8,4,5,6,7,3,9,10,11,12,13,14,15,16,17,18,19,20},
                 new Integer[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
    }

    @Test
    public void testSortLargeSortedArrayWithOnlyNegativeValues() {
        testSort(new Integer[] {-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1},
                 new Integer[] {-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1});
    }

    @Test
    public void testSortLargeReverseSortedArrayWithOnlyNegativeValues() {
        testSort(new Integer[] {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,-18,-19,-20},
                 new Integer[] {-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1});
    }

    @Test
    public void testSortJumbledArrayWithSmallRangeOfValues() {
        testSort(new Integer[] {5,-3,2,0,-5,1,4,-4,-2,3,-1},
                 new Integer[] {-5,-4,-3,-2,-1,0,1,2,3,4,5});
    }

    @Test
    public void testSortJumbledArrayWithLargeRangeOfValues() {
        testSort(new Integer[] {102,10,-50,2938,108,-4011,-38,523,16},
                 new Integer[] {-4011,-50,-38,10,16,102,108,523,2938});
    }

    @Test
    public void testSortArrayWithDuplicateValues() {
        testSort(new Integer[] {-2,-7,1,9,-7,1,-2,10,-7,-7},
                 new Integer[] {-7,-7,-7,-7,-2,-2,1,1,9,10});
    }
}
