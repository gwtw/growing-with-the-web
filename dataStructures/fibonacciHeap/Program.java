package dataStructures.fibonacciHeap;

import dataStructures.FibonacciHeap;

public class Program {
    public static void main(String[] args) {
        testMinimum();
        testDelete();
        testDecreaseKey();
        System.out.println("Tests passed");
    }

    private static void testMinimum() {
        FibonacciHeap<Integer> t = new FibonacciHeap<Integer>();
        t.insert(5);
        t.insert(1);
        t.insert(3);
        t.insert(8);
        t.insert(7);
        t.insert(4);
        t.insert(9);
        t.insert(2);
        t.insert(6);
        for (int i = 1; i <= 9; i++) {
            assert(t.findMinimum().getKey() == i);
            assert(t.extractMin().getKey() == i);
        }
        assert(t.isEmpty());
        System.out.println("testMinimum passed");
    }

    private static void testDelete() {
        FibonacciHeap<Integer> t = new FibonacciHeap<Integer>();
        FibonacciHeap.Node<Integer> node5 = t.insert(5);
        FibonacciHeap.Node<Integer> node1 = t.insert(1);
        FibonacciHeap.Node<Integer> node3 = t.insert(3);
        FibonacciHeap.Node<Integer> node4 = t.insert(4);
        FibonacciHeap.Node<Integer> node2 = t.insert(2);

        t.delete(node4);
        t.delete(node1);
        assert(t.findMinimum() == node2);

        t.delete(node2);
        assert(t.findMinimum() == node3);

        t.delete(node3);
        assert(t.findMinimum() == node5);
        System.out.println("testDelete passed");
    }

    private static void testDecreaseKey() {
        FibonacciHeap<Integer> t = new FibonacciHeap<Integer>();
        FibonacciHeap.Node<Integer> node5 = t.insert(5);
        FibonacciHeap.Node<Integer> node3 = t.insert(3);
        FibonacciHeap.Node<Integer> node4 = t.insert(4);
        FibonacciHeap.Node<Integer> node2 = t.insert(2);

        t.decreaseKey(node5, 1);
        assert(t.findMinimum() == node5);
        t.decreaseKey(node5, 0);
        assert(t.findMinimum() == node5);
        t.decreaseKey(node3, -2);
        assert(t.findMinimum() == node3);
        System.out.println("testDecreaseKey passed");
    }
}
