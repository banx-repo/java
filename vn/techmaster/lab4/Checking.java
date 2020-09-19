package vn.techmaster.lab4;

public class Checking {
    private Student student;
    private boolean attend = false;

    Checking(Student student) {
        this.student = student;
    }

    Checking(Student student, boolean attend) {
        this(student);
        this.attend = attend;
    }

    Student getStudent() {
        return this.student;
    }

    boolean getAttend() {
        return this.attend;
    }
}
