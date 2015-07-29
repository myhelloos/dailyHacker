package genericProgramming;

public class PairClass<T1, T2>{
private T1 firstItem;
private T2 secondItem;

public PairClass(T1 first, T2 second) {
        firstItem = first;
        secondItem = second;
}

public T1 first() {
        return firstItem;
}

public T2 second() {
        return secondItem;
}
}
