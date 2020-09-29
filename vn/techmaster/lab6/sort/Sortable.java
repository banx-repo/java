package vn.techmaster.lab6.sort;

import java.util.ArrayList;

@FunctionalInterface
public interface Sortable {
    ArrayList<Employee> sort(ArrayList<Employee> employees);
}
