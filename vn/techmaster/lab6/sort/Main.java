package vn.techmaster.lab6.sort;

import vn.techmaster.lab6.sort.sorter.*;

public class Main {
    public static void main(String[] args) {
        new Employee(1, "Ba");
        new Employee(4, "Thư");
        new Employee(3, "Vương");
        new Employee(5, "Anh");
        new Employee(2, "Thư");

        System.out.println("Before:");
        for (Employee e : Employee.employees) {
            e.print();
        }

        System.out.println();
        System.out.println("Selection Sort: ");
        Employee.sorter = new SelectionSort();
        Employee.sort();

        for (Employee e : Employee.employees) {
            e.print();
        }

        System.out.println();
        System.out.println("Bubble Sort: ");
        Employee.sorter = new BubbleSort();
        Employee.sort();

        for (Employee e : Employee.employees) {
            e.print();
        }

        System.out.println();
        System.out.println("Insertion Sort: ");
        Employee.sorter = new InsertionSort();
        Employee.sort();

        for (Employee e : Employee.employees) {
            e.print();
        }
    }
}
