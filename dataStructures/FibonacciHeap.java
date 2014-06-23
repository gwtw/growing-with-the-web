package dataStructures;

import java.lang.Comparable;
import java.lang.IllegalArgumentException;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FibonacciHeap<T extends Comparable<T>> {
    private Node<T> minNode;
    private int size;

    public FibonacciHeap() {
        size = 0;
        minNode = null;
    }

    private FibonacciHeap(Node<T> node) {
        size = 1;
        minNode = node;
    }

    private FibonacciHeap(Node<T> minNode, int size) {
        this.minNode = minNode;
        this.size = size;
    }

    public boolean isEmpty() {
        return minNode == null;
    }

    public void clear() {
        minNode = null;
    }

    public Node<T> insert(T key) {
        Node<T> node = new Node<T>(key);
        minNode = mergeLists(minNode, node);
        size++;
        return node;
    }

    public Node<T> findMinimum() {
        return minNode;
    }

    public void decreaseKey(Node<T> node, T newKey) {
        if (newKey.compareTo(node.key) > 0) 
            throw new IllegalArgumentException("New key is larger than old key.");
        
        node.key = newKey;
        Node<T> parent = node.parent;
        if (parent != null && node.compareTo(parent) < 0) {
            cut(node, parent);
            cascadingCut(parent);
        }
        if (node.compareTo(minNode) < 0)
            minNode = node;
    }

    private void cut(Node<T> node, Node<T> parent) {
        removeNodeFromList(node);
        parent.degree--;
        mergeLists(minNode, node);
        node.isMarked = false;
    }

    private void cascadingCut(Node<T> node) {
        Node<T> parent = node.parent;
        if (parent != null) {
            if (node.isMarked) {
                cut(node, parent);
                cascadingCut(parent);
            } else {
                node.isMarked = true;
            }
        }
    }

    public void delete(Node<T> node) {
        // This is a special implementation of decreaseKey that sets the
        // argument to the minimum value. This is necessary to make generic keys
        // work, since there is no MIN_VALUE constant for generic types.
        node.isMinimum = true;
        Node<T> parent = node.parent;
        if (parent != null) {
            cut(node, parent);
            cascadingCut(parent);
        }
        minNode = node;
        
        extractMin();
    }

    public Node<T> extractMin() {
        Node<T> extractedMin = minNode;
        if (extractedMin != null) {
            // Set parent to null for the minimum's children
            if (extractedMin.child != null) {
                Node<T> child = extractedMin.child;
                do {
                    child.parent = null;
                    child = child.next;
                } while (child != extractedMin.child);
            }

            Node<T> nextInRootList = minNode.next == minNode ? null : minNode.next;

            // Remove min from root list
            removeNodeFromList(extractedMin);
            size--;

            // Merge the children of the minimum node with the root list
            minNode = mergeLists(nextInRootList, extractedMin.child);
            
            if (nextInRootList != null) {
                minNode = nextInRootList;
                consolidate();
            }
        }
        return extractedMin;
    }

    private void consolidate() {
        List<Node<T>> aux = new ArrayList<Node<T>>();
        NodeListIterator<T> it = new NodeListIterator<T>(minNode);
        while (it.hasNext()) {
            Node<T> current = it.next();

            while (aux.size() <= current.degree + 1) {
                aux.add(null);
            }

            // If there exists another node with the same degree, merge them
            while (aux.get(current.degree) != null) {
                if (current.key.compareTo(aux.get(current.degree).key) > 0) {
                    Node<T> temp = current;
                    current = aux.get(current.degree);
                    aux.set(current.degree, temp);
                }
                linkHeaps(aux.get(current.degree), current);
                aux.set(current.degree, null);
                current.degree++;
            }

            while (aux.size() <= current.degree + 1) {
                aux.add(null);
            }
            aux.set(current.degree, current);
        }

        minNode = null;
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i) != null) {
                // Remove siblings before merging
                aux.get(i).next = aux.get(i);
                aux.get(i).prev = aux.get(i);
                minNode = mergeLists(minNode, aux.get(i));
            }
        }
    }

    private void removeNodeFromList(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        prev.next = next;
        next.prev = prev;

        node.next = node;
        node.prev = node;
    }

    private void linkHeaps(Node<T> max, Node<T> min) {
        removeNodeFromList(max);
        min.child = mergeLists(max, min.child);
        max.parent = min;
        max.isMarked = false;
    }

    // Union another fibonacci heap with this one
    public void union(FibonacciHeap<T> other) {
        minNode = mergeLists(minNode, other.minNode);
        size += other.size;
    }

    // Merged two lists and returns the minimum node
    public static <T extends Comparable<T>> Node<T> mergeLists(
            Node<T> a, Node<T> b) {

        // Assume a and b a
        if (a == null && b == null)
            return null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node<T> temp = a.next;
        a.next = b.next;
        a.next.prev = a;
        b.next = temp;
        b.next.prev = b;

        return a.compareTo(b) < 0 ? a : b;
    }
    
    public void print() {
        System.out.println("Fibonacci heap:");
        if (minNode != null)
            minNode.print(0);
    }

    public static class Node<T extends Comparable<T>>
            implements Comparable<Node<T>> {

        private T key;
        private int degree;
        private Node<T> parent;
        private Node<T> child;
        private Node<T> prev;
        private Node<T> next;
        private boolean isMarked;
        private boolean isMinimum;

        public Node() {
            key = null;
        }

        public Node(T key) {
            this.key = key;
            next = this;
            prev = this;
        }

        public T getKey() {
            return key;
        }

        public int compareTo(Node<T> other) {
            return this.key.compareTo(other.key);
        }

        private void print(int level) {
            Node<T> curr = this;
            do {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < level; i++) {
                    sb.append(" ");
                }
                sb.append(curr.key.toString());
                System.out.println(sb.toString());
                if (curr.child != null) {
                    curr.child.print(level + 1);
                }
                curr = curr.next;
            } while (curr != this);
        }
    }

    // This Iterator is used to simplify the consolidate() method. It works by
    // gathering a list of the nodes in the list in the constructor since the
    // nodes can change during consolidation.
    public static class NodeListIterator<T extends Comparable<T>>
            implements Iterator<Node<T>> {

        private Queue<Node<T>> items = new LinkedList<Node<T>>();

        public NodeListIterator(Node<T> start) {
            if (start == null)
                return;

            Node<T> current = start;
            do {
                items.add(current);
                current = current.next;
            } while (start != current);
        }

        public boolean hasNext() {
            return items.peek() != null;
        }

        public Node<T> next() {
            return items.poll();
        }

        public void remove() {
            throw new UnsupportedOperationException(
                    "NodeListIterator.remove is not implemented");
        }
    }
}
