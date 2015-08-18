package com.growingwiththeweb.algorithms.interviewquestions.reversealinkedlist;

import com.growingwiththeweb.algorithms.LinkedList;

public class Program {
    public static void main(String[] args) {
        LinkedList head = new LinkedList(new int[] {1, 2, 3, 4}, LinkedList.Type.SINGLY);
        head = reverseSingly(head);
        head.assertEquals(new int[] {4, 3, 2, 1}, LinkedList.Type.SINGLY);

        head = new LinkedList(new int[] {1, 2, 3, 4}, LinkedList.Type.DOUBLY);
        head = reverseDoubly(head);
        head.assertEquals(new int[] {4, 3, 2, 1}, LinkedList.Type.DOUBLY);

        System.out.println("Tests passed");
    }

    public static LinkedList reverseSingly(LinkedList head) {
        if (head != null) {
            LinkedList prev = null;
            while (head.next != null) {
                LinkedList next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            head.next = prev;
        }
        return head;
    }

    public static LinkedList reverseDoubly(LinkedList head) {
        while (head != null) {
            LinkedList temp = head.next;
            head.next = head.prev;
            head.prev = temp;
            if (temp == null)
                break;
            head = temp;
        }
        return head;
    }
}
