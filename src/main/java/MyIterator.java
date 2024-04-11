import java.util.Iterator;

/**
 * MyIterator - это обобщенный класс итератора, который проходит по массиву объектов.
 * Он реализует интерфейс Iterator. Нужен для реализации своего ArrayList.
 *
 * @param <T> тип элементов в массиве
 */
public class MyIterator<T> implements Iterator<T> {

    private T[] objects;
    private int index = 0;

    MyIterator(T[] objects) {
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public T next() {
        return objects[index++];
    }
}