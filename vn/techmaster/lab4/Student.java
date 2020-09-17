package vn.techmaster.lab4;

public class Student {
    int id;
    String fullName;
    int age;

    Student(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    void hello() {
        System.out.println("Hello, my name is " + this.fullName);
    }
}
