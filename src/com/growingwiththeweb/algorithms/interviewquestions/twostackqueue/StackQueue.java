package com.growingwiththeweb.algorithms.interviewquestions.twostackqueue;

import java.util.Stack;

public class StackQueue<T> {
    Stack<T> s1 = new Stack<T>();
    Stack<T> s2 = new Stack<T>();

    void push(T obj) {
        s1.push(obj);
    }

    T pop() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                return null;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
}
