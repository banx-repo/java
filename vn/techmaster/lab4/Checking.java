package vn.techmaster.lab4;

public class Checking {
    Student student;
    boolean attend = false;

    Checking(Student student) {
        this.student = student;
    }

    Checking(Student student, boolean attend) {
        this(student);
        this.attend = attend;
    }
}
