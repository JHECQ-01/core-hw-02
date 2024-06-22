package org.example;

public class MyStack {
    private Node head;
    private int size;

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
        }
    }

    public void push(Object value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public Object remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return pop();
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Object removedValue = current.next.value;
        current.next = current.next.next;
        size--;
        return removedValue;
    }

    public void clear() {
        head = null;
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

    public Object pop() {
        if (size == 0) {
            return null;
        }
        Object value = head.value;
        head = head.next;
        size--;
        return value;
    }
}
