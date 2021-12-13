package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList elements;

    public Stack() {
        elements = new ImmutableLinkedList();
    }

    public void push(Object e) {
        this.elements = this.elements.addLast(e);
    }

    public Object pop() {
        Object res = this.elements.getLast();
        this.elements = this.elements.removeLast();
        return res;
    }

    public Object peek() {
        return this.elements.getLast();
    }
}
