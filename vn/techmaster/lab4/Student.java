package vn.techmaster.lab4;

public class Student {
    static private int count = 1;
    private int id;
    private String fullName;
    private int age;

    Student(int id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    void print() {
        System.out.printf("%4s  %4s  %-30s\n", this.id, this.age, this.fullName);
    }

    static int getNewId() {
        return count++;
    }

    static int getTotal() {
        return count - 1;
    }

    int getId() {
        return this.id;
    }

    String getFullName() {
        return this.fullName;
    }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }

    int getAge() {
        return this.age;
    }

    void setAge(int age) {
        this.age = age;
    }
}
