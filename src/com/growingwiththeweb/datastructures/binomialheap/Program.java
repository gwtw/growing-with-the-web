package com.growingwiththeweb.datastructures.binomialheap;

public class Program {
    public static void main(String[] args) {
        testMinimum();
        testDelete();
        testDecreaseKey();
        System.out.println("Tests passed");
    }

    private static void testMinimum() {
        BinomialHeap<Integer> t = new BinomialHeap<Integer>();
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
            assert(t.findMinimum() == i);
            assert(t.extractMin() == i);
        }
    }

    private static void testDelete() {
        BinomialHeap<Integer> t = new BinomialHeap<Integer>();
        BinomialHeap.Node<Integer> node = null;
        t.insert(5);
        t.insert(1);
        t.insert(3);
        t.insert(4);
        t.insert(2);

        node = t.search(4);
        assert(node != null);
        t.delete(node);

        node = t.search(1);
        assert(node != null);
        t.delete(node);
        assert(t.findMinimum() == 2);

        node = t.search(2);
        assert(node != null);
        t.delete(node);
        assert(t.findMinimum() == 3);

        node = t.search(3);
        assert(node != null);
        t.delete(node);
        assert(t.findMinimum() == 5);
    }

    private static void testDecreaseKey() {
        BinomialHeap<Integer> t = new BinomialHeap<Integer>();
        BinomialHeap.Node<Integer> node = null;
        t.insert(5);
        t.insert(3);
        t.insert(4);
        t.insert(2);

        node = t.search(5);
        t.decreaseKey(node, 1);
        assert(t.findMinimum() == 1);
    }
}
