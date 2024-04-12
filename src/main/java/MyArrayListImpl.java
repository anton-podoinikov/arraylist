import java.util.Arrays;
import java.util.Iterator;

/**
 * Реализация списка с массивом переменной длины.
 * Этот класс предоставляет реализацию методов для управления коллекцией,
 * хранящей элементы в массиве. Класс позволяет добавлять, удалять, получать элементы,
 * а также сортировать и очищать список.
 *
 * @param <E> тип элементов в массиве
 */
public class MyArrayListImpl<E> implements MyArrayList<E> {

    private E[] values;

    public MyArrayListImpl() {
        values = (E[]) new Object[0];
    }

    /**
     * Добавляет элемент в конец списка.
     * Элемент добавляется в конец текущего массива, при этом размер массива
     * увеличивается на один.
     *
     * @param e элемент для добавления в список
     * @return всегда возвращает true
     */
    @Override
    public boolean add(E e) {
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, temp.length);
        values[values.length - 1] = e;
        return true;
    }

    /**
     * Вставляет указанный элемент в заданной позиции списка.
     * Элементы, начиная с указанного индекса, сдвигаются вправо.
     *
     * @param index индекс, по которому нужно вставить элемент
     * @param e элемент для вставки
     */
    @Override
    public void add(int index, E e) {
        checkSize(index);
        E[] temp = values;
        values = (E[]) new Object[temp.length + 1];
        System.arraycopy(temp, 0, values, 0, index);
        values[index] = e;
        System.arraycopy(temp, index, values, index + 1, temp.length - index);
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента для возврата
     * @return элемент на указанном индексе
     */
    @Override
    public E get(int index) {
        checkSize(index);
        return values[index];
    }

    /**
     * Удаляет элемент в указанной позиции.
     * Элементы после указанной позиции сдвигаются влево.
     *
     * @param index индекс удаляемого элемента
     */
    @Override
    public void remove(int index) {
        checkSize(index);
        E[] temp = values;
        values = (E[]) new Object[temp.length - 1];
        System.arraycopy(temp, 0, values, 0, index);
        System.arraycopy(temp, index + 1, values, index, temp.length - index - 1);
    }

    /**
     * Очищает список, устанавливая все его элементы в null.
     */
    @Override
    public void clear() {
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }

    /**
     * Сортирует список с использованием сортировки вставками.
     * Список должен содержать элементы, реализующие интерфейс Comparable.
     */
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

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    @Override
    public int size() {
        return values.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(values);
    }

    @Override
    public String toString() {
        return "MyArrayListImpl{" +
                "values=" + Arrays.toString(values) +
                '}';
    }

    private void checkSize(int index) {
        if (index < 0 || index > values.length) {
            throw new IndexOutOfBoundsException("Index " + index + ", Size: " + size());
        }
    }
}
