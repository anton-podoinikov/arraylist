import java.util.Iterator;

/**
 * MyIterator - это обобщенный класс итератора, который проходит по массиву объектов.
 * Он реализует интерфейс Iterator.
 *
 * @param <T> тип элементов в массиве
 */
public class MyIterator<T> implements Iterator<T> {

    private T[] objects; // Массив объектов
    private int index = 0; // Текущий индекс итерации

    /**
     *  Конструктор MyIterator с указанным массивом объектов.
     *
     * @param objects массив объектов для итерации
     */
    MyIterator(T[] objects) {
        this.objects = objects;
    }

    /**
     * Проверяет, есть ли еще элементы для итерации
     *
     * @return true, если есть еще элемент, иначе false
     */
    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    /**
     * Возвращает следующий элемент в итерации.
     */
    @Override
    public T next() {
        return objects[index++];
    }
}