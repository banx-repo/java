package vn.techmaster.lab4;

public class Subject {
    private static int count = 1;
    private int id;
    private String name;

    Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void print() {
        System.out.printf("%4s  %-50s\n", this.id, this.name);
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

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }
}
