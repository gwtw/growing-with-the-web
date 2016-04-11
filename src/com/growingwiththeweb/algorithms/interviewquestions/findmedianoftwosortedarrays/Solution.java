package com.growingwiththeweb.algorithms.interviewquestions.findmedianoftwosortedarrays;

import java.lang.IllegalArgumentException;

public class Solution {
    /**
     * Gets the median of two sorted arrays.
     *
     * @param A The first sorted array.
     * @param B The second sorted array.
     * @return The median of A and B.
     */
    public static double findMedian(int[] A, int[] B) {
        return findMedianInternal(A, 0, A.length - 1, B, 0, B.length - 1);
    }

    /**
     * Gets the median of two sorted arrays.
     *
     * @param A The first sorted array.
     * @param aStart The start index of A to use.
     * @param aEnd The end index of A to use.
     * @param B The second sorted array.
     * @param bStart The start index of B to use.
     * @param bEnd The end index of B to use.
     * @return The median of A and B.
     */
    private static double findMedianInternal(
            int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd) {
        // Check actual lengths here instead of start/end since the arrays
        // themselves don't change in recursive calls
        if (A.length == 0 && B.length == 0) {
            throw new IllegalArgumentException(
                    "Both arrays cannot be zero-length");
        }
        if (A.length == 0) {
            return medianOfArray(B, bStart, bEnd);
        }
        if (B.length == 0) {
            return medianOfArray(A, aStart, aEnd);
        }

        int aLength = (aEnd - aStart) + 1;
        int bLength = (bEnd - bStart) + 1;
        if (aLength == 1 && bLength == 1) {
            return (A[aStart] + B[bStart]) / 2d;
        }
        if (aLength == 1 && bLength > 1) {
            return findMedianOfArrayAndValue(B, bStart, bEnd, A[aStart]);
        }
        if (bLength == 1 && aLength > 1) {
            return findMedianOfArrayAndValue(A, aStart, aEnd, B[bStart]);
        }
        
        if (aLength == 2 && bLength >= 2 && bLength % 2 == 0) {
            if (areValuesInMiddleOfEvenArray(B, bStart, bEnd, A[aStart], A[aEnd])) {
                return (A[aStart] + A[aEnd]) / 2d;
            }
        }
        if (bLength == 2 && aLength >= 2 && aLength % 2 == 0) {
            if (areValuesInMiddleOfEvenArray(A, aStart, aEnd, B[bStart], B[bEnd])) {
                return (B[bStart] + B[bEnd]) / 2d;
            }
        }

        double medianA = medianOfArray(A, aStart, aEnd);
        double medianB = medianOfArray(B, bStart, bEnd);
        if (medianA == medianB) {
            return medianA;
        }
        int maxDiscardable = Math.min((aEnd - aStart) / 2 - 1,
                                      (bEnd - bStart) / 2 - 1);
        if (maxDiscardable < 1) {
            maxDiscardable = 1;
        }
        if (medianA < medianB) {
            return findMedianInternal(A, aStart + maxDiscardable, aEnd,
                                      B, bStart, bEnd - maxDiscardable);
        }
        return findMedianInternal(A, aStart, aEnd - maxDiscardable,
                                  B, bStart + maxDiscardable, bEnd);
    }

    /**
     * Gets whether two values belong in sorted order in the middle of an array.
     * 
     * @param array The sorted array.
     * @param start The start of the array to use.
     * @param end The end of the array to use.
     * @param small The smaller number.
     * @param large The larger number.
     * @return Whether the two values belong in the middle.
     */
    private static boolean areValuesInMiddleOfEvenArray(
            int[] array, int start, int end, int small, int large) {
        int midIndex = (end + start) / 2;
        return small > array[midIndex] && large < array[midIndex + 1];
    }

    /**
     * Gets the median of a sorted array and an additional value.
     *
     * @param array The sorted array.
     * @param start The start of the array to use.
     * @param end The end of the array to use.
     * @param value The additional value to include in median calculation.
     * @return The median of the array including the additional value.
     */
    private static double findMedianOfArrayAndValue(
            int[] array, int start, int end, int value) {
        double arrayMedian = medianOfArray(array, start, end);
        if (arrayMedian == value) {
            return arrayMedian;
        }
        // If array[start..end].length is even
        if ((end - start) % 2 == 1) {
            return findMedianOfArrayAndValueEvenCase(array, start, end, arrayMedian, value);
        }
        return findMedianOfArrayAndValueOddCase(array, start, end, arrayMedian, value);
    }

    /**
     * Gets the median of a sorted array with an odd number of elements plus an
     * additional value.
     *
     * @param array The sorted array.
     * @param start The start of the array to use.
     * @param end The end of the array to use.
     * @param arrayMedian The median of the array excluding the additional
     * value.
     * @param value The additional value to include in median calculation.
     * @return The median of the array including the additional value.
     */
    private static double findMedianOfArrayAndValueOddCase(
            int[] array, int start, int end, double arrayMedian, int value) {
        int midIndex = (end + start) / 2;
        int left = array[midIndex - 1];
        int mid = array[midIndex];
        int right = array[midIndex + 1];
        if (value < left) {
            return (mid + left) / 2d;
        }
        if (value > right) {
            return (mid + right) / 2d;
        }
        return (mid + value) / 2d;
    }

    /**
     * Gets the median of a sorted array with an even number of elements plus an
     * additional value.
     *
     * @param array The sorted array.
     * @param start The start of the array to use.
     * @param end The end of the array to use.
     * @param arrayMedian The median of the array excluding the additional
     * value.
     * @param value The additional value to include in median calculation.
     * @return The median of the array including the additional value.
     */
    private static double findMedianOfArrayAndValueEvenCase(
            int[] array, int start, int end, double arrayMedian, int value) {
        if (arrayMedian > value) {
            int left = array[(end - start) / 2];
            return Math.max(left, value);
        } else {
            int right = array[(end - start) / 2 + 1];
            return Math.min(right, value);
        }
    }

    /**
     * Gets the median of a single sorted array.
     *
     * @param array The sorted array to get the median of.
     * @param start The start of the array to use.
     * @param end The end of the array to use.
     * @return The median of the array.
     */
    private static double medianOfArray(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        }
        int mid = (start + end) / 2;
        // If array[start..end].length is even
        if ((end - start) % 2 == 1) {
            return (array[mid] + array[mid + 1]) / 2d;
        }
        return array[mid];
    }
}
