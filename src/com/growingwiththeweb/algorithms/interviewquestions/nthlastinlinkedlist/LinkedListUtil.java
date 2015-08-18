package com.growingwiththeweb.algorithms.interviewquestions;

import com.growingwiththeweb.algorithms.LinkedList;

public class LinkedListUtil {
    /**
     * Gets the nth last element of a linked list.
     *
     * @param head The head of the linked list.
     * @param n The number of elements to count backward.
     * @return The nth last element of the linked list, if it is not large
     * enough, return 0
     */
    public static LinkedList getNthLastElement(LinkedList head, int n) {
        if (head == null || n < 1) {
            return null;
        }

        LinkedList current = head;
        LinkedList nBehindCurrent = head;
        int countBehindCurrent = 0;

        for (int i = 0; i < n - 1; i++) {
            current = current.next;
            if (current == null) {
                return null;
            }
        }

        while (current.next != null) {
            nBehindCurrent = nBehindCurrent.next;
            current = current.next;
        }

        return nBehindCurrent;
    }
}
