package es15;

import java.util.ArrayList;
import java.util.List;

public class CustomCollection<T extends Comparable<T>> {
    private final List<T> list;

    public CustomCollection() {
        list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public T get(int index) {
        if (list.size() <= index)
            return null;

        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public void remove(int index) {
        if (list.size() <= index)
            return;

        list.remove(index);
    }


    public void sort(java.util.Comparator<? super T> comparator) {
        list.sort(comparator);
    }

    public T getMax() {
        T max = list.getFirst();

        for (T elem : list) {
            if (max.compareTo(elem) < 0)
                max = elem;
        }

        return max;
    }

    public static <T extends Comparable<T>> CustomCollection<T> merge(CustomCollection<T> c1, CustomCollection<T> c2) {
        CustomCollection<T> merged = new CustomCollection<>();

        for (int i = 0; i < c1.size(); i++)
            merged.add(c1.get(i));

        for (int i = 0; i < c2.size(); i++)
            merged.add(c2.get(i));

        return merged;
    }
}
