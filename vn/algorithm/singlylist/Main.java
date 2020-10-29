package vn.algorithm.singlylist;

import vn.algorithm.singlylist.LinkedList.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(list.new Node(1));
        list.addLast(list.new Node(2));
        list.addLast(list.new Node(3));
        list.addLast(list.new Node(4));
        list.addFirst(list.new Node(0));
        System.out.println(list.first());
        System.out.println(list.last());
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.removeFirst();
        list.removeLast();
        list.insert(list.new Node(45), 2);

        Node n = list.first();
        while (n.getNext() != null) {
            System.out.println(n.getData());
            n = n.getNext();
        }
    }
}
