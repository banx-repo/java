package vn.techmaster.lab11;

public class List {
    Node head;

    List() {
        head = null;
    }

    public void add(Node next) {
        if (head == null) {
            head = next;
        } else {
            Node tmp = head;

            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }

            tmp.setNext(next);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node tmp = head;

        while (tmp != null) {
            sb.append(tmp.getValue()).append(", ");
            tmp = tmp.getNext();
        }

        return sb.toString();
    }
}
