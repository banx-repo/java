package vn.techmaster.lab6.sort;

import java.util.ArrayList;

import vn.lib.ClearScreen;

public class Main {
    public static void main(String[] args) {
        ClearScreen.clear();

        Sortable bubble = (ArrayList<Employee> employees) -> {
            ArrayList<Employee> clone = new ArrayList<Employee>(employees);
            Employee min;

            for (int i = 0; i < clone.size() - 1; i++) {
                min = clone.get(i);

                for (int j = i + 1; j < clone.size(); j++) {
                    if (min.getId() < clone.get(j).getId()) {
                        clone.set(i, clone.get(j));
                        clone.set(j, min);
                        min = clone.get(i);
                    }
                }
            }

            return clone;
        };

        Sortable selection = (ArrayList<Employee> employees) -> {
            ArrayList<Employee> clone = new ArrayList<Employee>(employees);
            Employee min;
            int index;

            for (int i = 0; i < clone.size() - 1; i++) {
                min = clone.get(i);
                index = i;

                for (int j = i + 1; j < clone.size(); j++) {
                    if (min.getId() < clone.get(j).getId()) {
                        min = clone.get(j);
                        index = j;
                    }
                }

                if (index != i) {
                    clone.set(index, clone.get(i));
                    clone.set(i, min);
                }
            }

            return clone;
        };

        Sortable insertion = (ArrayList<Employee> employees) -> {
            ArrayList<Employee> clone = new ArrayList<Employee>(employees);
            Employee min;

            for (int i = 1; i < clone.size(); i++) {
                min = clone.get(i);
                int j = i - 1;

                while ((j > -1) && (clone.get(j).getId() < min.getId())) {
                    clone.set(j + 1, clone.get(j));
                    j--;
                }

                clone.set(j + 1, min);
            }

            return clone;
        };

        new Employee("Ba");
        new Employee("Thư");
        new Employee("Vương");
        new Employee("Béo Ú");

        System.out.println("Before:");
        Employee.getAll().forEach(e -> e.print());

        System.out.println("\nSelection Sort: ");
        Employee.setSorter(selection);
        Employee.sort().forEach(e -> e.print());

        System.out.println("\nBubble Sort: ");
        Employee.setSorter(bubble);
        Employee.sort().forEach(e -> e.print());

        System.out.println("\nInsertion Sort: ");
        Employee.setSorter(insertion);
        Employee.sort().forEach(e -> e.print());

        System.out.println("\nAfter:");
        Employee.getAll().forEach(e -> e.print());
    }
}
