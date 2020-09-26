package vn.techmaster.lab6.sort;

import java.util.ArrayList;
import vn.techmaster.lab6.sort.sorter.Sortable;

public class Employee {
    public int id;
    public String name;

    public static ArrayList<Employee> employees = new ArrayList<>();
    public static Sortable sorter;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;

        employees.add(this);
    }

    public static void sort() {
        sorter.sort(employees);
    }

    void print() {
        System.out.println(this.id + " " + this.name);
    }
}
