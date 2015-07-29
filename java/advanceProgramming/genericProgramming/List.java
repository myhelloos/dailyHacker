package genericProgramming;

public class List<T> {
private T[] dataStore;
private int size;
private int pos;

public List(int numElements) {
        size = numElements;
        pos = 0;
        dataStore = (T[]) new Object[size];
}

public void add(T element) {
        dataStore[pos] = element;
        ++pos;
}

public String toString() {
        StringBuilder elements = new StringBuilder();
        for (int i=0; i<pos; i++) {
                elements.append(dataStore[i]).append(" ");
        }
        return elements.toString();
}
}
