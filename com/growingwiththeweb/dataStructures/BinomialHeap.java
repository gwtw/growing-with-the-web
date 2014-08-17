package com.growingwiththeweb.dataStructures;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

public class BinomialHeap<T extends Comparable<T>> {

    private Node<T> head;

    public BinomialHeap() {
        head = null;
    }

    public BinomialHeap(Node<T> head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void insert(T key) {
        Node<T> node = new Node<T>(key);
        BinomialHeap<T> tempHeap = new BinomialHeap<T>(node);
        head = union(tempHeap);
    }

    public T findMinimum() {
        if (head == null) {
            return null;
        } else {
            Node<T> min = head;
            Node<T> next = min.sibling;

            while (next != null) {
                if (next.compareTo(min) < 0) {
                    min = next;
                }
                next = next.sibling;
            }

            return min.key;
        }
    }

    // Implemented to test delete/decrease key, runs in O(n) time
    public Node<T> search(T key) {
        List<Node<T>> nodes = new ArrayList<Node<T>>();
        nodes.add(head);
        while (!nodes.isEmpty()) {
            Node<T> curr = nodes.get(0);
            nodes.remove(0);
            if (curr.key == key) {
                return curr;
            }
            if (curr.sibling != null) {
                nodes.add(curr.sibling);
            }
            if (curr.child != null) {
                nodes.add(curr.child);
            }
        }
        return null;
    }

    public void decreaseKey(Node<T> node, T newKey) {
        node.key = newKey;
        bubbleUp(node, false);
    }

    public void delete(Node<T> node) {
        node = bubbleUp(node, true);
        if (head == node) {
            removeTreeRoot(node, null);
        } else {
            Node<T> prev = head;
            while (prev.sibling.compareTo(node) != 0) {
                prev = prev.sibling;
            }
            removeTreeRoot(node, prev);
        }
    }

    private Node<T> bubbleUp(Node<T> node, boolean toRoot) {
        Node<T> parent = node.parent;
        while (parent != null && (toRoot || node.compareTo(parent) < 0)) {
            T temp = node.key;
            node.key = parent.key;
            parent.key = temp;
            node = parent;
            parent = parent.parent;
        }
        return node;
    }

    public T extractMin() {
        if (head == null) {
            return null;
        }

        Node<T> min = head;
        Node<T> minPrev = null;
        Node<T> next = min.sibling;
        Node<T> nextPrev = min;

        while (next != null) {
            if (next.compareTo(min) < 0) {
                min = next;
                minPrev = nextPrev;
            }
            nextPrev = next;
            next = next.sibling;
        }

        removeTreeRoot(min, minPrev);
        return min.key;
    }

    private void removeTreeRoot(Node<T> root, Node<T> prev) {
        // Remove root from the heap
        if (root == head) {
            head = root.sibling;
        } else {
            prev.sibling = root.sibling;
        }

        // Reverse the order of root's children and make a new heap
        Node<T> newHead = null;
        Node<T> child = root.child;
        while (child != null) {
            Node<T> next = child.sibling;
            child.sibling = newHead;
            child.parent = null;
            newHead = child;
            child = next;
        }
        BinomialHeap<T> newHeap = new BinomialHeap<T>(newHead);

        // Union the heaps and set its head as this.head
        head = union(newHeap);
    }

    // Merge two binomial trees of the same order
    private void linkTree(Node<T> minNodeTree, Node<T> other) {
        other.parent = minNodeTree;
        other.sibling = minNodeTree.child;
        minNodeTree.child = other;
        minNodeTree.degree++;
    }

    // Union two binomial heaps into one and return the head
    public Node<T> union(BinomialHeap<T> heap) {
        Node<T> newHead = merge(this, heap);

        head = null;
        heap.head = null;

        if (newHead == null) {
            return null;
        }

        Node<T> prev = null;
        Node<T> curr = newHead;
        Node<T> next = newHead.sibling;

        while (next != null) {
            if (curr.degree != next.degree || (next.sibling != null &&
                    next.sibling.degree == curr.degree)) {
                prev = curr;
                curr = next;
            } else {
                if (curr.compareTo(next) < 0) {
                    curr.sibling = next.sibling;
                    linkTree(curr, next);
                } else {
                    if (prev == null) {
                        newHead = next;
                    } else {
                        prev.sibling = next;
                    }

                    linkTree(next, curr);
                    curr = next;
                }
            }

            next = curr.sibling;
        }

        return newHead;
    }

    private static <T extends Comparable<T>> Node<T> merge(
            BinomialHeap<T> heap1, BinomialHeap<T> heap2) {
        if (heap1.head == null) {
            return heap2.head;
        } else if (heap2.head == null) {
            return heap1.head;
        } else {
            Node<T> head;
            Node<T> heap1Next = heap1.head;
            Node<T> heap2Next = heap2.head;

            if (heap1.head.degree <= heap2.head.degree) {
                head = heap1.head;
                heap1Next = heap1Next.sibling;
            } else {
                head = heap2.head;
                heap2Next = heap2Next.sibling;
            }

            Node<T> tail = head;

            while (heap1Next != null && heap2Next != null) {
                if (heap1Next.degree <= heap2Next.degree) {
                    tail.sibling = heap1Next;
                    heap1Next = heap1Next.sibling;
                } else {
                    tail.sibling = heap2Next;
                    heap2Next = heap2Next.sibling;
                }

                tail = tail.sibling;
            }

            if (heap1Next != null) {
                tail.sibling = heap1Next;
            } else {
                tail.sibling = heap2Next;
            }

            return head;
        }
    }

    public void print() {
        System.out.println("Binomial heap:");
        if (head != null) {
            head.print(0);
        }
    }

    public static class Node<T extends Comparable<T>>
            implements Comparable<Node<T>> {
        public T key;
        public int degree;
        public Node<T> parent;
        public Node<T> child;
        public Node<T> sibling;

        public Node() {
            key = null;
        }

        public Node(T key) {
            this.key = key;
        }

        public int compareTo(Node<T> other) {
            return this.key.compareTo(other.key);
        }

        public void print(int level) {
            Node<T> curr = this;
            while (curr != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < level; i++) {
                    sb.append(" ");
                }
                sb.append(curr.key.toString());
                System.out.println(sb.toString());
                if (curr.child != null) {
                    curr.child.print(level + 1);
                }
                curr = curr.sibling;
            }
        }
    }

}
