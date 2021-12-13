package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    Node head;
    Node tail;
    int length;

    public ImmutableLinkedList(Object[] elements) {
        Node previous = new Node();
        previous.setValue(elements[0]);
        previous.setPrevious(null);
        head = previous;

        for (int i = 1; i < elements.length-1; i++) {
            final Node node = new Node();
            node.setValue(elements[i]);
            node.setPrevious(previous);
            previous.setNext(node);

            previous = node;

        }
        tail = new Node();
        tail.setValue(elements[elements.length-1]);
        tail.setPrevious(previous);
        tail.setNext(null);
        previous.setNext(tail);

        length = elements.length;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return addLast(e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] new_elements = new Object[this.length+1];
        Node curr = this.head;

        for (int i = 0; i < this.length+1; i++) {
            if (i == index) {
                new_elements[i] = e;
            } else {
                new_elements[i] = curr.getValue();
                curr = curr.getNext();
            }
        }
        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] new_elements = new Object[this.length+c.length];

        Node curr = this.head;
        for (int i = 0; i < this.length; i++) {
            new_elements[i] = curr.getValue();
            curr = curr.getNext();
        }

        int counter = 0;
        for (int i = this.length; i < this.length+c.length; i++) {
            new_elements[i] = c[counter++];
        }

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] new_elements = new Object[this.length+c.length];

        Node curr = this.head;

        for (int i = 0; i < index; i++) {
            new_elements[i] = curr.getValue();
            curr = curr.getNext();
        }

        int counter = 0;
        for (int i = index; i < index + c.length; i++) {
            new_elements[i] = c[counter++];
        }

        for (int i = index + c.length; i < this.length+c.length; i++) {
            new_elements[i] = curr.getValue();
            curr = curr.getNext();
        }

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public Object get(int index) {
        Node curr = this.head;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (counter == index) {
                return curr.getValue();
            } else {
                curr = curr.getNext();
                counter++;
            }
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] new_elements = new Object[this.length-1];

        int counter = 0;
        Node curr = this.head;
        for (int i = 0; i < this.length; i++) {
            if (i != index) {
                new_elements[counter++] = curr.getValue();
                curr = curr.getNext();
            }
        }

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Object[] new_elements = new Object[this.length];

        int counter = 0;
        Node curr = this.head;
        for (int i = 0; i < this.length; i++) {
            if (i == index) {
                new_elements[i] = e;
            } else {
                new_elements[counter++] = curr.getValue();
            }
            curr = curr.getNext();
        }

        return new ImmutableLinkedList(new_elements);
    }

    @Override
    public int indexOf(Object e) {
        Node curr = this.head;
        for (int i = 0; i < this.length; i++) {
            if (e == curr.getValue()) {
                return i;
            } else {
                curr = curr.getNext();
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return (length == 0) ? true : false;
    }

    @Override
    public Object[] toArray() {
        Object[] new_elements = new Object[this.length];

        Node curr = this.head;
        for (int i = 0; i < this.length; i++) {
            new_elements[i] = curr.getValue();
            curr = curr.getNext();
        }

        return new_elements;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] new_elements = new Object[this.length+1];

        Node curr = this.head;
        new_elements[0] = e;
        for (int i = 1; i < this.length+1; i++) {
            new_elements[i] = curr.getValue();
            curr = curr.getNext();
        }

        return new ImmutableLinkedList(new_elements);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] new_elements = new Object[this.length+1];

        Node curr = this.head;
        for (int i = 0; i < this.length; i++) {
            new_elements[i] = curr.getValue();
            curr = curr.getNext();
        }

        new_elements[this.length] = e;
        return new ImmutableLinkedList(new_elements);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        Object[] new_elements = new Object[this.length-1];

        int counter = 0;
        Node curr = this.head.getNext();
        for (int i = 0; i < this.length-1; i++) {
            new_elements[counter++] = curr.getValue();
            curr = curr.getNext();

        }

        return new ImmutableLinkedList(new_elements);
    }

    public ImmutableLinkedList removeLast() {
        if (this.length > 1) {
            Object[] new_elements = new Object[this.length - 1];

            int counter = 0;
            Node curr = this.head;
            for (int i = 0; i < this.length - 1; i++) {
                new_elements[counter++] = curr.getValue();
                curr = curr.getNext();
            }

            return new ImmutableLinkedList(new_elements);
        } else {
            return new ImmutableLinkedList();
        }
    }


}
