package genericProgramming;

public class Node<T> {
private T data;
public Node<T> next;

public Node(T data) {
        this.data = data;
        this.next = null;
}

T getData() {
        return this.data;
}
}
