package vn.techmaster.lab11;

public class Node {
    int value;
    Node next;

    Node(int value, Node next) {
        setValue(value);
        setNext(next);
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
