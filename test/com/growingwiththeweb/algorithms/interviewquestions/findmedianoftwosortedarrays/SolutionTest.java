package com.growingwiththeweb.algorithms.interviewquestions.findmedianoftwosortedarrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.IllegalArgumentException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class SolutionTest {
    @Test(expected=IllegalArgumentException.class)
    public void testTwoEmptyArrays() {
        Solution.findMedian(new int[] {}, new int[] {});
    }

    @Test
    public void testSingleElementArray() {
        assertEquals(1d, Solution.findMedian(new int[] {}, new int[] {1}), 0d);
        assertEquals(1d, Solution.findMedian(new int[] {1}, new int[] {}), 0d);
    }

    @Test
    public void testTwoSingleElementArrays() {
        assertEquals(2d, Solution.findMedian(new int[] {1}, new int[] {3}), 0d);
    }

    @Test
    public void testEmptyFirstArray() {
        assertEquals(3d, Solution.findMedian(new int[] {}, new int[] {1, 2, 3, 4, 5}), 0d);
        assertEquals(10d, Solution.findMedian(new int[] {}, new int[] {-2, 6, 10, 22, 23}), 0d);
        assertEquals(4d, Solution.findMedian(new int[] {}, new int[] {1, 2, 4, 4, 5, 6}), 0d);
        assertEquals(3.5d, Solution.findMedian(new int[] {}, new int[] {1, 2, 3, 4, 5, 6}), 0d);
    }

    @Test
    public void testEmptySecondArray() {
        assertEquals(3d, Solution.findMedian(new int[] {1, 2, 3, 4, 5}, new int[] {}), 0d);
        assertEquals(10d, Solution.findMedian(new int[] {-2, 6, 10, 22, 23}, new int[] {}), 0d);
        assertEquals(4d, Solution.findMedian(new int[] {1, 2, 4, 4, 5, 6}, new int[] {}), 0d);
        assertEquals(3.5d, Solution.findMedian(new int[] {1, 2, 3, 4, 5, 6}, new int[] {}), 0d);
    }

    @Test
    public void testTwoSmallArrays() {
        assertEquals(5d, Solution.findMedian(new int[] {1, 3, 5, 6}, new int[] {3, 5, 6, 8}), 0d);
        assertEquals(5.5d, Solution.findMedian(new int[] {3, 4, 5, 6, 7}, new int[] {4, 5, 6, 7, 8}), 0d);
        assertEquals(4d, Solution.findMedian(new int[] {1, 2, 3, 4}, new int[] {4, 5, 6, 7}), 0d);
        assertEquals(4.5d, Solution.findMedian(new int[] {1, 2, 3, 4}, new int[] {5, 6, 7, 8}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {1, 2, 3, 4}, new int[] {6, 7, 8, 9}), 0d);
        assertEquals(5.5d, Solution.findMedian(new int[] {1, 2, 3, 4}, new int[] {7, 8, 9, 10}), 0d);
        assertEquals(1d, Solution.findMedian(new int[] {1, 1, 1, 1}, new int[] {1, 1, 1, 1}), 0d);
        assertEquals(3.5d, Solution.findMedian(new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 4, 5, 6}), 0d);
        assertEquals(2.5d, Solution.findMedian(new int[] {-1, 0, 1, 2, 5}, new int[] {2, 3, 4, 5, 6}), 0d);
    }

    @Test
    public void testLargerFirstArray() {
        assertEquals(5d, Solution.findMedian(new int[] {1, 2, 4, 6, 7}, new int[] {3, 5, 8, 9}), 0d);
        assertEquals(5.5d, Solution.findMedian(new int[] {1, 2, 3, 4, 5, 6, 8, 9, 10}, new int[] {7}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {1, 2, 3, 4, 5, 6, 8, 9}, new int[] {7}), 0d);
        assertEquals(3.5d, Solution.findMedian(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {1, 2, 3}), 0d);
        assertEquals(3d, Solution.findMedian(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, new int[] {1, 2, 3}), 0d);
        assertEquals(4.5d, Solution.findMedian(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[] {2, 3}), 0d);
        assertEquals(4d, Solution.findMedian(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {2, 3}), 0d);
    }

    @Test
    public void testLargerFirstArrayWhenMedianIsOther() {
        assertEquals(5d, Solution.findMedian(new int[] {1, 2, 3, 4, 6, 7, 8, 9}, new int[] {5}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {4, 7}, new int[] {5}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {1, 4, 7, 9}, new int[] {5}), 0d);
    }

    @Test
    public void testLargerSecondArray() {
        assertEquals(5d, Solution.findMedian(new int[] {3, 5, 8, 9}, new int[] {1, 2, 4, 6, 7}), 0d);
        assertEquals(5.5d, Solution.findMedian(new int[] {7}, new int[] {1, 2, 3, 4, 5, 6, 8, 9, 10}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {7}, new int[] {1, 2, 3, 4, 5, 6, 8, 9}), 0d);
        assertEquals(3.5d, Solution.findMedian(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}), 0d);
        assertEquals(3d, Solution.findMedian(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5, 6, 7, 8}), 0d);
        assertEquals(4.5d, Solution.findMedian(new int[] {2, 3}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 0d);
        assertEquals(4d, Solution.findMedian(new int[] {2, 3}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}), 0d);
    }

    @Test
    public void testLargerSecondArrayWhenMedianIsOther() {
        assertEquals(5d, Solution.findMedian(new int[] {5}, new int[] {1, 2, 3, 4, 6, 7, 8, 9}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {5}, new int[] {4, 7}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {5}, new int[] {1, 4, 7, 9}), 0d);
    }

    @Test
    public void testArrayAndValueFallBackLeftLeftCase() {
        assertEquals(2.5d, Solution.findMedian(new int[] {-1}, new int[] {1, 4, 7}), 0d);
        assertEquals(2.5d, Solution.findMedian(new int[] {0}, new int[] {1, 4, 7}), 0d);
        assertEquals(2.5d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {-1}), 0d);
        assertEquals(2.5d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {0}), 0d);
    }

    @Test
    public void testArrayAndValueFallBackLeftCase() {
        assertEquals(3d, Solution.findMedian(new int[] {2}, new int[] {1, 4, 7}), 0d);
        assertEquals(3.5d, Solution.findMedian(new int[] {3}, new int[] {1, 4, 7}), 0d);
        assertEquals(3d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {2}), 0d);
        assertEquals(3.5d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {3}), 0d);
    }

    @Test
    public void testArrayAndValueFallBackMidCase() {
        assertEquals(4d, Solution.findMedian(new int[] {4}, new int[] {1, 4, 7}), 0d);
        assertEquals(4d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {4}), 0d);
    }

    @Test
    public void testArrayAndValueFallBackRightCase() {
        assertEquals(4.5d, Solution.findMedian(new int[] {5}, new int[] {1, 4, 7}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {6}, new int[] {1, 4, 7}), 0d);
        assertEquals(4.5d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {5}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {6}), 0d);
    }

    @Test
    public void testArrayAndValueFallBackRightRightCase() {
        assertEquals(5.5d, Solution.findMedian(new int[] {8}, new int[] {1, 4, 7}), 0d);
        assertEquals(5.5d, Solution.findMedian(new int[] {9}, new int[] {1, 4, 7}), 0d);
        assertEquals(5.5d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {8}), 0d);
        assertEquals(5.5d, Solution.findMedian(new int[] {1, 4, 7}, new int[] {9}), 0d);
    }
    
    @Test
    public void testTwoValuesAndEvenArrayCase() {
        assertEquals(5d, Solution.findMedian(new int[] {-50, -47, -36, -35, 0, 13, 14, 16}, new int[] {-31, 1, 9, 23, 30, 39}), 0d);
        assertEquals(5d, Solution.findMedian(new int[] {-47, -36, -35, 0, 13, 14}, new int[] {-31, 1, 9, 23, 30, 39}), 0d);
    }
}
