package vn.techmaster.lab9;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        HumanResource hm = new HumanResource();
        hm.add(new Developer("Béo Ú"));
        hm.add(new Security("LoL"));
        hm.add(new Developer("Ba Còi"));

        System.out.println();
        for (Employee e : hm.employees) {
            System.out.println(e);
        }

        Collections.sort(hm.employees);

        System.out.println();
        for (Employee e : hm.employees) {
            System.out.println(e);
        }
    }
}
