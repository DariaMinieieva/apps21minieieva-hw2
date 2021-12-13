package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class NodeTest extends TestCase {

    public void testTestToString() {
        Node node = new Node();
        node.setValue("Hello");

        assertEquals(node.toString(), "Hello");
    }

    public void testGetPrevious() {
        Node node = new Node();
        node.setPrevious(null);

        assertEquals(node.getPrevious(), null);
    }
}