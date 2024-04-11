public interface MyArrayList<E> extends Iterable<E> {
    boolean add(E e);
    void add(int index, E e);
    E get(int index);
    E remove(int index);
    void clear();
    void sort();
}
