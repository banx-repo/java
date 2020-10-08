package vn.techmaster.lab11;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.add(new Node(10, null));
        list.add(new Node(11, null));
        list.add(new Node(12, null));

        System.out.println(list);
    }
}
