import java.util.Comparator;

/**
 * Класс QuickSort предоставляет статический метод для сортировки списка,
 * реализованного через MyArrayListImpl, используя алгоритм быстрой сортировки (Quick Sort).
 * Алгоритм выбирает элемент (опорный элемент) и разделяет список на две части:
 * элементы меньше опорного и элементы больше опорного.
 * Затем алгоритм рекурсивно сортирует эти подсписки.
 */
public class QuickSort {

    /**
     * Сортирует список, используя алгоритм быстрой сортировки.
     * Этот метод модифицирует исходный список, возвращая его отсортированную версию.
     * Сортировка осуществляется на основе переданного компаратора, который определяет
     * порядок элементов.
     *
     * @param list       список для сортировки, реализованный через MyArrayListImpl
     * @param comparator компаратор, определяющий порядок элементов в списке
     * @return отсортированная версия исходного списка
     * @throws IllegalArgumentException если переданный список или компаратор являются null
     */
    public static <E> MyArrayListImpl<E> quickSort(MyArrayListImpl<E> list, Comparator<E> comparator) {
        if (list.size() < 2) {
            return list;
        } else {
            E pivot = list.get(0);

            MyArrayListImpl<E> less = new MyArrayListImpl<>();
            MyArrayListImpl<E> greater = new MyArrayListImpl<>();

            for (int i = 1; i < list.size(); i++) {
                E item = list.get(i);
                if (comparator.compare(item, pivot) <= 0) {
                    less.add(item);
                } else {
                    greater.add(item);
                }
            }

            MyArrayListImpl<E> sorted = quickSort(less, comparator);
            sorted.add(pivot);
            sorted.addAll(quickSort(greater, comparator));

            return sorted;
        }
    }
}

