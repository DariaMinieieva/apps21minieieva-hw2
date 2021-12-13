package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList elements;

    public Queue() {
        elements = new ImmutableLinkedList();
    }


    public Object peek() {
        return this.elements.getFirst();
    }

    public Object dequeue() {
        Object res = this.elements.getFirst();
        this.elements = this.elements.removeFirst();
        return res;
    }

    public void enqueue(Object e) {
        this.elements = this.elements.addLast(e);
    }
}
