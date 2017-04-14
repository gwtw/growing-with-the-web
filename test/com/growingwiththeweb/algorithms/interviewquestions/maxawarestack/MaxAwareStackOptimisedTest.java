package com.growingwiththeweb.algorithms.interviewquestions.maxawarestack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MaxAwareStackOptimisedTest {
    @Test
    public void testEmptyStackValue() {
        MaxAwareStackOptimised<Integer> stack = new MaxAwareStackOptimised<Integer>();
        assertNull(stack.pop());
        stack.push(1);
        stack.pop();
        assertNull(stack.pop());
    }

    @Test
    public void testPushPop() {
        MaxAwareStackOptimised<Integer> stack = new MaxAwareStackOptimised<Integer>();
        stack.push(1);
        assertEquals(1, (int)stack.pop());
        stack.push(1);
        stack.push(2);
        assertEquals(2, (int)stack.pop());
        assertEquals(1, (int)stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, (int)stack.pop());
        assertEquals(2, (int)stack.pop());
        assertEquals(1, (int)stack.pop());
    }

    @Test
    public void testPushPopShuffled() {
        MaxAwareStackOptimised<Integer> stack = new MaxAwareStackOptimised<Integer>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, (int)stack.pop());
        stack.push(3);
        stack.push(4);
        assertEquals(4, (int)stack.pop());
        stack.push(5);
        assertEquals(5, (int)stack.pop());
        assertEquals(3, (int)stack.pop());
        assertEquals(1, (int)stack.pop());
    }

    @Test
    public void testMaxEmpty() {
        MaxAwareStackOptimised<Integer> stack = new MaxAwareStackOptimised<Integer>();
        assertNull(stack.getMax());
        stack.push(1);
        stack.pop();
        assertNull(stack.getMax());
    }

    @Test
    public void testMaxPushPop() {
        MaxAwareStackOptimised<Integer> stack = new MaxAwareStackOptimised<Integer>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        assertEquals(3, (int)stack.getMax());
        stack.pop();
        assertEquals(3, (int)stack.getMax());
        stack.pop();
        assertEquals(1, (int)stack.getMax());
        stack.pop();
        assertNull(stack.getMax());
    }

    @Test
    public void testMaxDuplicates() {
        MaxAwareStackOptimised<Integer> stack = new MaxAwareStackOptimised<Integer>();
        stack.push(1);
        stack.push(1);
        stack.push(2);
        stack.push(2);
        assertEquals(2, (int)stack.getMax());
        stack.pop();
        assertEquals(2, (int)stack.getMax());
        stack.pop();
        assertEquals(1, (int)stack.getMax());
        stack.pop();
        assertEquals(1, (int)stack.getMax());
        stack.pop();
        assertNull(stack.getMax());
    }
}
