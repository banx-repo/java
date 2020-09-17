package vn.techmaster.lab4;

import java.util.Scanner;

public class Student {
    static int id;
    String fullName;
    int age;

    Student(int id, String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    String getName(Scanner in) {
        System.out.print("Student name: ");
        return in.nextLine();
    }

    int getAge(Scanner in) {
        System.out.print("Student age: ");
        return in.nextInt();
    }

    String getFullName() {
        return this.fullName;
    }

    void setFullName(String name) {
        this.fullName = name;
    }

    
}
