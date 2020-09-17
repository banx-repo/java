package vn.techmaster.lab4;

public class Course {
    int id;
    String name;
    SubjectTeacher[] listSubjectTeachers;
    Student[] listStudents;

    Course(int id, String name, SubjectTeacher[] listSubjectTeachers, Student[] listStudents) {
        this.id = id;
        this.name = name;
        this.listSubjectTeachers = listSubjectTeachers;
        this.listStudents = listStudents;
    }
}
