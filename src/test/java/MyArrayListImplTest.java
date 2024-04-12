import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class MyArrayListImplTest {
    private MyArrayList<Integer> list;

    @Before
    public void setUp() {
        list = new MyArrayListImpl<>();
    }

    @Test
    public void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testAddByIndex() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();

        assertNull(list.get(0));
        assertNull(list.get(1));
        assertNull(list.get(2));
    }

    @Test
    public void testSort() {
        list.add(3);
        list.add(2);
        list.add(1);

        list.sort();

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));

    }

    @Test
    public void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext());
    }
}

