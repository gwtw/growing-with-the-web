package com.growingwiththeweb.algorithms.interviewquestions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.growingwiththeweb.algorithms.LinkedList;

public class LinkedListUtilTest {
    @Test
    public void testNull() {
        assertNull(LinkedListUtil.getNthLastElement(null, 1));
    }

    @Test
    public void testNegative() {
        assertNull(LinkedListUtil.getNthLastElement(null, -1));
        assertNull(LinkedListUtil.getNthLastElement(null, -2));
    }

    @Test
    public void testSingleElementList() {
        LinkedList head = new LinkedList(1);
        assertEquals(head, LinkedListUtil.getNthLastElement(head, 1));
        assertNull(LinkedListUtil.getNthLastElement(head, 2));
    }

    @Test
    public void testTwoElementList() {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        assertEquals(head.next, LinkedListUtil.getNthLastElement(head, 1));
        assertEquals(head, LinkedListUtil.getNthLastElement(head, 2));
        assertNull(LinkedListUtil.getNthLastElement(head, 3));
    }

    @Test
    public void testListSmallList() {
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(3);
        assertEquals(head.next.next, LinkedListUtil.getNthLastElement(head, 1));
        assertEquals(head.next, LinkedListUtil.getNthLastElement(head, 2));
        assertEquals(head, LinkedListUtil.getNthLastElement(head, 3));
        assertNull(LinkedListUtil.getNthLastElement(head, 4));
    }

    @Test
    public void testLargeList() {
        LinkedList head = new LinkedList(1);
        LinkedList current = head;
        for (int i = 2; i <= 100; i++) {
            current.next = new LinkedList(i);
            current = current.next;
        }
        current = head;
        for (int i = 1; i <= 100; i++) {
            assertEquals(current, LinkedListUtil.getNthLastElement(head, 101 - i));
            current = current.next;
        }
        assertNull(LinkedListUtil.getNthLastElement(head, 101));
    }
}
