package vn.techmaster.lab5.person;

public enum Class {
    G(1), H(2), I(3), K(4), L(5), M(6);

    private int c;

    Class(int c) {
        this.c = c;
    }

    int get() {
        return this.c;
    }
}
