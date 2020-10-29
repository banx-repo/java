package vn.algorithm.singlylist;

public class LinkedList {
    class Node {
        public Node(int data) {
            this.data = data;
        }

        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public void addFirst(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }

        size++;
    }

    public Node first() {
        return head;
    }

    public Node last() {
        return tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }

        Node node = head;
        head = head.next;
        node.next = null;

        if (--size == 0) {
            tail = null;
        }

        return node;
    }

    public Node removeLast() {
        if (tail == null) {
            throw new NullPointerException();
        }

        Node temp = head;
        Node node = tail;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = null;

        if (--size == 0) {
            head = null;
        }

        return node;
    }

    public void insert(Node node, int index) {
        if (head == null) {
            throw new NullPointerException();
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        int count = 0;
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;

            if (++count == index - 1) {
                break;
            }
        }

        node.next = temp.next;
        temp.next = node;
    }
}