package vn.techmaster.lab4;

public class Teacher {
    int id;
    String fullName;
    Subject[] listSubjects;

    Teacher(int id, String fullName, Subject[] listSubjects) {
        this.id = id;
        this.fullName = fullName;
        this.listSubjects = listSubjects;
    }
}
