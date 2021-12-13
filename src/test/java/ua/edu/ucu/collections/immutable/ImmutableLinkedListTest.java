package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;


public class ImmutableLinkedListTest extends TestCase {

    public void testAdd() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_add = "Dasha";

        Object[] check = {1,2,3,"AshaD", "Dasha"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.add(to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testTestAdd() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_add = "Dasha";

        Object[] check = {1,2,"Dasha",3,"AshaD"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.add(2, to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testAddAll() {
        Object[] test = {1,2,3,"AshaD"};
        Object[] to_add = {"Dasha", "Karyna", "Sasha"};

        Object[] check = {1,2,3,"AshaD", "Dasha", "Karyna", "Sasha"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.addAll(to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testTestAddAll() {
        Object[] test = {1,2,3,"AshaD"};
        Object[] to_add = {"Dasha", "Karyna", "Sasha"};

        Object[] check = {1,2,3, "Dasha", "Karyna", "Sasha","AshaD"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.addAll(3, to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testGet() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        Object to_get = listik.get(1);
        Object to_get_2 = listik.get(5);

        assertEquals(to_get, 2);
        assertEquals(to_get_2, null);
    }

    public void testRemove() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_remove = "AshaD";

        Object[] check = {1,2,3};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.remove(3);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testSet() {
        Object[] test = {1,2,3,"AshaD"};

        Object[] check = {1,2,3, "Dasha"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.set(3, "Dasha");

        assertArrayEquals(check, new_l.toArray());
    }

    public void testIndexOf() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_index = "AshaD";

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        int indx = listik.indexOf(to_index);
        int indx_2 = listik.indexOf(5);

        assertEquals(indx, 3);
        assertEquals(indx_2, -1);
    }

    public void testSize() {
        Object[] test = {1,2,3,"AshaD"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        int size = listik.size();

        assertEquals(size, 4);
    }

    public void testClear() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableList check = new ImmutableLinkedList();

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.clear();

        assertArrayEquals(check.toArray(), new_l.toArray());
    }

    public void testIsEmpty() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableList check = new ImmutableLinkedList();
        ImmutableLinkedList listik = new ImmutableLinkedList(test);


        assertEquals(listik.isEmpty(), false);
        assertEquals(check.isEmpty(), true);
    }

    public void testAddFirst() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_add = "Dasha";

        Object[] check = {"Dasha",1,2,3,"AshaD"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.addFirst(to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testGetHead() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableLinkedList listik = new ImmutableLinkedList(test);

        assertEquals(listik.getHead().getValue(), 1);
    }

    public void testGetTail() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableLinkedList listik = new ImmutableLinkedList(test);

        assertEquals(listik.getTail().getValue(), "AshaD");
    }

    public void testGetFirst() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableLinkedList listik = new ImmutableLinkedList(test);

        assertEquals(listik.getFirst(), 1);
    }

    public void testGetLast() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableLinkedList listik = new ImmutableLinkedList(test);

        assertEquals(listik.getLast(), "AshaD");
    }

    public void testRemoveFirst() {

        Object[] test = {1,2,3,"AshaD"};

        Object[] check = {2,3,"AshaD"};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.removeFirst();

        assertArrayEquals(check, new_l.toArray());
    }

    public void testRemoveLast() {
        Object[] test = {1,2,3,"AshaD"};

        Object[] check = {1,2,3};

        ImmutableLinkedList listik = new ImmutableLinkedList(test);
        ImmutableList new_l = listik.removeLast();

        assertArrayEquals(check, new_l.toArray());
    }

    public void  testToArray() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableLinkedList listik = new ImmutableLinkedList(test);

        assertArrayEquals(test, listik.toArray());
    }
}