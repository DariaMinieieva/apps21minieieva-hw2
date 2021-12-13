package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    Object[] elements;

    public ImmutableArrayList(Object[] elements) {
        this.elements = new Object[elements.length];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    public ImmutableArrayList() {
        this.elements = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] new_elements = new Object[this.elements.length+1];

        for (int i = 0; i < this.elements.length; i++) {
            new_elements[i] = elements[i];
        }

        new_elements[this.elements.length] = e;
        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] new_elements = new Object[this.elements.length+1];

        int counter = 0;
        for (int i = 0; i < this.elements.length+1; i++) {
            if (i == index) {
                new_elements[i] = e;
            } else {
                new_elements[i] = this.elements[counter++];
            }
        }
        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] new_elements = new Object[this.elements.length+c.length];

        for (int i = 0; i < this.elements.length; i++) {
            new_elements[i] = elements[i];
        }

        int counter = 0;
        for (int i = this.elements.length; i < this.elements.length+c.length; i++) {
            new_elements[i] = c[counter++];
        }

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] new_elements = new Object[this.elements.length+c.length];


        for (int i = 0; i < index; i++) {
            new_elements[i] = this.elements[i];
        }

        int counter = 0;
        for (int i = index; i < index + c.length; i++) {
            new_elements[i] = c[counter++];
        }

        counter = index;
        for (int i = index + c.length; i < this.elements.length+c.length; i++) {
            new_elements[i] = this.elements[counter++];
        }

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] new_elements = new Object[this.elements.length-1];

        int counter = 0;
        for (int i = 0; i < this.elements.length; i++) {
            if (i != index) {
                new_elements[counter++] = elements[i];
            } else {
                i++;
            }
        }

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] new_elements = new Object[this.elements.length];

        for (int i = 0; i < this.elements.length; i++) {
            new_elements[i] = this.elements[i];
        }

        new_elements[index] = e;

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.elements.length; i++) {
            if (e == elements[i]) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return this.elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return (this.elements.length == 0) ? true : false;
    }

    @Override
    public Object[] toArray() {
        Object[] new_elements = new Object[this.elements.length];

        for (int i = 0; i < this.elements.length; i++) {
            new_elements[i] = this.elements[i];
        }

        return new_elements;
    }
}
