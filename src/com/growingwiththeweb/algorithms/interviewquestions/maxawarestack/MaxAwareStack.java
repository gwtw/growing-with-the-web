package com.growingwiththeweb.algorithms.interviewquestions.maxawarestack;

import java.lang.Comparable;
import java.util.Stack;

public class MaxAwareStack<T extends Comparable<T>> {
    private Stack<MaxAwareEntry> stack = new Stack<>();

    public void push(T obj) {
        MaxAwareEntry entry = new MaxAwareEntry(obj);
        if (stack.isEmpty()) {
            entry.max = obj;
        } else {
            T currentMax = stack.peek().max;
            entry.max =  currentMax.compareTo(obj) > 0 ? currentMax : obj;
        }
        stack.push(entry);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.pop().value;
    }

    public T getMax() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek().max;
    }

    private class MaxAwareEntry {
        public T value;
        public T max;

        public MaxAwareEntry(T value) {
            this.value = value;
        }
    }
}
