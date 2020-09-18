package vn.techmaster.lab4;

public class Teacher {
    private static int count = 1;
    private int id;
    private String fullName;
    private Subject[] listSubjects;

    Teacher(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    Teacher(int id, String fullName, Subject[] listSubjects) {
        this(id, fullName);
        this.listSubjects = listSubjects;
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

    Subject[] getListSubjects() {
        return this.listSubjects;
    }

    void setListSubjects(Subject[] listSubjects) {
        this.listSubjects = listSubjects;
    }
}
