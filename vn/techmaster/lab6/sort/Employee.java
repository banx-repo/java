package vn.techmaster.lab6.sort;

import java.util.ArrayList;

public class Employee {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Sortable sorter;
    private static int count = 0;
    private int id;
    private String name;

    // static
    public static int total() {
        return count;
    }

    public static ArrayList<Employee> getAll() {
        return employees;
    }

    public static void setSorter(Sortable sortable) {
        sorter = sortable;
    }

    public static ArrayList<Employee> sort() {
        return sorter.sort(employees);
    }

    // private
    private int getNewId() {
        return count++;
    }

    // get
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    // set
    public void setName(String name) {
        this.name = name;
    }

    private void setId() {
        this.id = this.getNewId();
    }

    // constructor
    Employee(String name) {
        this.setId();
        this.setName(name);
        employees.add(this);
    }

    // other
    void print() {
        System.out.println(this.id + " " + this.name);
    }
}
