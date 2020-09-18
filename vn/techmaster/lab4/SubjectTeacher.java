package vn.techmaster.lab4;

public class SubjectTeacher {
    private static int count = 1;
    private int id;
    private Subject subject;
    private Teacher teacher;

    SubjectTeacher(int id, Subject subject, Teacher teacher) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
    }

    void print() {
        System.out.printf("%4s  %-30s %s\n", this.id, this.subject.getName(), this.teacher.getFullName());
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

    Subject getSubject() {
        return this.subject;
    }

    void setSubject(Subject subject) {
        this.subject = subject;
    }

    Teacher getTeacher() {
        return this.teacher;
    }

    void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
