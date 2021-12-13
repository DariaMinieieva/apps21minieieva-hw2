package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {
    private Object[] elements;

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
        Object[] newElements = new Object[this.elements.length+1];

        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = elements[i];
        }

        newElements[this.elements.length] = e;
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newElements = new Object[this.elements.length+1];

        int counter = 0;
        for (int i = 0; i < this.elements.length+1; i++) {
            if (i == index) {
                newElements[i] = e;
            } else {
                newElements[i] = this.elements[counter++];
            }
        }
        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newElements = new Object[this.elements.length+c.length];

        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = elements[i];
        }

        int counter = 0;
        for (int i = this.elements.length;
             i < this.elements.length+c.length; i++) {
            newElements[i] = c[counter++];
        }

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newElements = new Object[this.elements.length+c.length];


        for (int i = 0; i < index; i++) {
            newElements[i] = this.elements[i];
        }

        int counter = 0;
        for (int i = index; i < index + c.length; i++) {
            newElements[i] = c[counter++];
        }

        counter = index;
        for (int i = index + c.length; i < this.elements.length+c.length;
             i++) {
            newElements[i] = this.elements[counter++];
        }

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newElements = new Object[this.elements.length-1];

        int counter = 0;
        for (int i = 0; i < this.elements.length; i++) {
            if (i != index) {
                newElements[i] = elements[counter++];
            } else {
                counter++;
            }
        }

        return new ImmutableLinkedList(newElements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newElements = new Object[this.elements.length];

        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }

        newElements[index] = e;

        return new ImmutableLinkedList(newElements);
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
        return (this.elements.length == 0);
    }

    @Override
    public Object[] toArray() {
        Object[] newElements = new Object[this.elements.length];

        for (int i = 0; i < this.elements.length; i++) {
            newElements[i] = this.elements[i];
        }

        return newElements;
    }
}
