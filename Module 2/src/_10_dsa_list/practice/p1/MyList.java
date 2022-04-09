package _10_dsa_list.practice.p1;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 15;
    private Object dataList[];

    public MyList() {
        dataList = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        dataList = new Object[capacity];
    }

    void add(E item) {
        size += 1;
        ensureCapacity(1);
        dataList[size - 1] = item;
    }

    void ensureCapacity(int minCapacity) {
        if (size > dataList.length) {
            int biggerSize = size + minCapacity;
            dataList = Arrays.copyOf(dataList, biggerSize);
        }
    }

    void add(int index, E item) {
        if (index >= 0 && index <= size) {
            size += 1;
            ensureCapacity(1);
            for (int i = size - 2; i >= index; i--) {
                dataList[i+1] = dataList[i];
            }
            dataList[index] = item;
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                dataList[i] = dataList[i + 1];
            }
            size -= 1;
            return true;
        }
        return false;
    }

    int size() {
        return size;
    }

    public Object[] getData() {
        return this.dataList;
    }

    E get(int index) {
        if (index >= 0 && index < size) {
            return (E) dataList[index];
        }
        return null;
    }

    void clear() {
        dataList = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (dataList[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    int indexOf(E item) {
        for (int i = 0; i < size; i++) {
            if (dataList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
