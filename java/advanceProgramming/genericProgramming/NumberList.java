package genericProgramming;

public class NumberList<T> implements IList<T> {
private T[] dataStore;
private int size;
private int pos;

public NumberList(int numElements) {
        size = numElements;
        pos = 0;
        dataStore = (T[]) new Object[numElements];
}

public void add(T element) {
        dataStore[pos] = element;
        pos++;
}

public T get(int n) {
        return dataStore  [n];
}
}
