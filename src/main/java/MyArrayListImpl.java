import java.util.Arrays;
import java.util.Iterator;


/**
 * MyArrayListImpl класс, который реализует часто используемые методы
 * класса ArrayList.
 *
 * @param <E> тип элементов в массиве
 */
public class MyArrayListImpl<E> implements MyArrayList<E> {

    private E[] values;

    public MyArrayListImpl() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;
        return true;
    }

    @Override
    public void add(int index, E e) {
        checkSize(index);
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, index);
        values[index] = e;
        System.arraycopy(temp, index, values, index + 1, temp.length - index);
    }

    @Override
    public E get(int index) {
        checkSize(index);
        return values[index];
    }

    @Override
    public void remove(int index) {
        checkSize(index);
        E[] temp = values;
        values = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, values, 0, index);
        System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
    }

    @Override
    public void clear() {
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }

    @Override
    public void sort() {
        try {
            for (int i = 1; i < values.length; i++) {
                E current = values[i];
                int j = i - 1;
                while (j >= 0 && ((Comparable<E>) values[j]).compareTo(current) > 0) {
                    values[j + 1] = values[j];
                    j--;
                }
                values[j + 1] = current;
            }
        } catch (NullPointerException | ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(values);
    }

    private void checkSize(int index) {
        if (index < 0 || index > values.length) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size: " + size());
        }
    }

    @Override
    public String toString() {
        return "MyArrayListImpl{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
