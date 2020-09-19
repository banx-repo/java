package vn.techmaster.lab5.Vehicle;

public class C extends Bike {
    void lol() {
        super.get().hello();
    }

    public static void main(String[] args) {
        C c = new C();
        c.lol();
    }
}
