package vn.techmaster.lab6.sort;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Sortable bubble = (ArrayList<Employee> employees) -> {
            Employee min;
            for (int i = 0; i < employees.size() - 1; i++) {
                min = employees.get(i);
                for (int j = i + 1; j < employees.size(); j++) {
                    if (min.id > employees.get(j).id) {
                        employees.set(i, employees.get(j));
                        employees.set(j, min);
                        min = employees.get(i);
                    }
                }
            }
        };

        Sortable selection = (ArrayList<Employee> employees) -> {
            Employee min;
            int index;
            for (int i = 0; i < employees.size() - 1; i++) {
                min = employees.get(i);
                index = i;

                for (int j = i + 1; j < employees.size(); j++) {
                    if (min.id < employees.get(j).id) {
                        min = employees.get(j);
                        index = j;
                    }
                }

                if (index != i) {
                    employees.set(index, employees.get(i));
                    employees.set(i, min);
                }
            }
        };

        Sortable insertion = (ArrayList<Employee> employees) -> {
            Employee min;
            for (int i = 1; i < employees.size(); i++) {
                min = employees.get(i);

                int j = i - 1;
                while ((j > -1) && (employees.get(j).id < min.id)) {
                    employees.set(j + 1, employees.get(j));
                    j--;
                }

                employees.set(j + 1, min);
            }
        };

        new Employee(1, "Ba");
        new Employee(4, "Thư");
        new Employee(3, "Vương");
        new Employee(5, "Anh");
        new Employee(2, "Thư");

        System.out.println("Before:");
        Employee.employees.forEach(e -> e.print());

        System.out.println("\nSelection Sort: ");
        Employee.sorter = selection;
        Employee.sort();
        Employee.employees.forEach(e -> e.print());

        System.out.println("\nBubble Sort: ");
        Employee.sorter = bubble;
        Employee.sort();
        Employee.employees.forEach(e -> e.print());

        System.out.println("\nInsertion Sort: ");
        Employee.sorter = insertion;
        Employee.sort();
        Employee.employees.forEach(e -> e.print());
    }
}
