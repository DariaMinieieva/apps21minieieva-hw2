package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class ImmutableArrayListTest extends TestCase {

    public void testAdd() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_add = "Dasha";

        Object[] check = {1,2,3,"AshaD", "Dasha"};

        ImmutableArrayList listik = new ImmutableArrayList(test);
        ImmutableList new_l = listik.add(to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testTestAdd() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_add = "Dasha";

        Object[] check = {1,2,"Dasha",3,"AshaD"};

        ImmutableArrayList listik = new ImmutableArrayList(test);
        ImmutableList new_l = listik.add(2, to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testAddAll() {
        Object[] test = {1,2,3,"AshaD"};
        Object[] to_add = {"Dasha", "Karyna", "Sasha"};

        Object[] check = {1,2,3,"AshaD", "Dasha", "Karyna", "Sasha"};

        ImmutableArrayList listik = new ImmutableArrayList(test);
        ImmutableList new_l = listik.addAll(to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testTestAddAll() {
        Object[] test = {1,2,3,"AshaD"};
        Object[] to_add = {"Dasha", "Karyna", "Sasha"};

        Object[] check = {1,2,3, "Dasha", "Karyna", "Sasha","AshaD"};

        ImmutableArrayList listik = new ImmutableArrayList(test);
        ImmutableList new_l = listik.addAll(3, to_add);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testGet() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableArrayList listik = new ImmutableArrayList(test);
        Object to_get = listik.get(1);

        assertEquals(to_get, 2);
    }

    public void testRemove() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_remove = "AshaD";

        Object[] check = {1,2,3};

        ImmutableArrayList listik = new ImmutableArrayList(test);
        ImmutableList new_l = listik.remove(3);

        assertArrayEquals(check, new_l.toArray());
    }

    public void testSet() {
        Object[] test = {1,2,3,"AshaD"};

        Object[] check = {1,2,3, "Dasha"};

        ImmutableArrayList listik = new ImmutableArrayList(test);
        ImmutableList new_l = listik.set(3, "Dasha");

        assertArrayEquals(check, new_l.toArray());
    }

    public void testIndexOf() {
        Object[] test = {1,2,3,"AshaD"};
        Object to_index = "AshaD";

        ImmutableArrayList listik = new ImmutableArrayList(test);
        int indx = listik.indexOf(to_index);

        assertEquals(indx, 3);
    }

    public void testSize() {
        Object[] test = {1,2,3,"AshaD"};

        ImmutableArrayList listik = new ImmutableArrayList(test);
        int size = listik.size();

        assertEquals(size, 4);
    }

    public void testClear() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableList check = new ImmutableArrayList();

        ImmutableArrayList listik = new ImmutableArrayList(test);
        ImmutableList new_l = listik.clear();

        assertArrayEquals(check.toArray(), new_l.toArray());
    }

    public void testIsEmpty() {
        Object[] test = {1,2,3,"AshaD"};
        ImmutableList check = new ImmutableArrayList();
        ImmutableArrayList listik = new ImmutableArrayList(test);


        assertEquals(listik.isEmpty(), false);
        assertEquals(check.isEmpty(), true);
    }

}