import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {
    Comparator<String> stringComparator = Comparator.naturalOrder();
    MyArrayListImpl<String> myArrayList = new MyArrayListImpl<>();

    @Test
    public void testQuickSort(){
        myArrayList.add("ddd");
        myArrayList.add("ccc");
        myArrayList.add("bbb");
        myArrayList.add("aaa");
        myArrayList.add("hhh");
        myArrayList.add("jjj");
        myArrayList.add("www");

        MyArrayListImpl<String> stringsCompare = QuickSort.quickSort(myArrayList, stringComparator);

        assertEquals("aaa", stringsCompare.get(0));
        assertEquals("bbb", stringsCompare.get(1));
        assertEquals("ccc", stringsCompare.get(2));
        assertEquals("ddd", stringsCompare.get(3));
        assertEquals("hhh", stringsCompare.get(4));
        assertEquals("jjj", stringsCompare.get(5));
        assertEquals("www", stringsCompare.get(6));
    }
}
