package com.growingwiththeweb.algorithms.interviewquestions.maxawarestack;

import java.lang.Comparable;
import java.util.Stack;

public class MaxAwareStackOptimised<T extends Comparable<T>> {
    private Stack<T> valueStack = new Stack<T>();
    private Stack<T> maxStack = new Stack<T>();

    public void push(T obj) {
        if (maxStack.size() == 0 || obj.compareTo(getMax()) >= 0) {
            maxStack.push(obj);
        }
        valueStack.push(obj);
    }

    public T pop() {
        if (valueStack.size() == 0) {
            return null;
        }
        T result = this.valueStack.pop();
        if (result == getMax()) {
            this.maxStack.pop();
        }
        return result;
    }

    public T getMax() {
        if (maxStack.size() == 0) {
            return null;
        }
        return maxStack.peek();
    }
}
