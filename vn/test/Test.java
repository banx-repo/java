package vn.test;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        LocalDate c = d;
        c = null;
        System.out.println(d);
    }
}
