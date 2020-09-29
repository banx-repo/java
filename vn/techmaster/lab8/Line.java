package vn.techmaster.lab8;

public class Line {
    public static void main(String[] args) {
        Gate a = new Gate("A");
        Gate b = new Gate("B");
        Gate c = new Gate("C");
        Gate d = new Gate("D");

        Ticket t1 = new OneWay(a, b);
        Ticket t2 = new OneWay(c, d);
        System.out.println(t1.isActive());
        System.out.println(t2.isActive());
        System.out.println(t2.getId());
    }
}
