package org.example;

public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (size == 0) {
            return null;
        }
        return head.value;
    }

    public Object poll() {
        if (size == 0) {
            return null;
        }
        Object value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }
}
