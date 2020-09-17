package vn.test;

import java.sql.Date;

public class OnLab {
    public static void main(String[] args) {
        Room lab2 = new Room("Java 1B", "Tầng 12A, Viwaseen, 48 Tố Hữu, Nam Từ Liêm, Hà Nội");

        // students
        Student beou = new Student(1, "Béo Ú", 29);
        Student phuong = new Student(2, "Phuong", 24);
        Student thai = new Student(3, "Thai", 25);

        // subjects
        Subject java = new Subject(1, "Java Full Stack");
        Subject html = new Subject(2, "HTML5");
        Subject css = new Subject(3, "CSS3");
        Subject js = new Subject(4, "JavaScript");

        // teachers
        Teacher minh = new Teacher(1, "Minh", new Subject[] { java });
        Teacher thanh = new Teacher(2, "Thanh", new Subject[] { java });
        Teacher ba = new Teacher(3, "Ba Nguyễn", new Subject[] { html, css, js });

        // subject teacher
        SubjectTeacher java1a = new SubjectTeacher(java, thanh);
        SubjectTeacher java1b = new SubjectTeacher(java, minh);
        SubjectTeacher html5 = new SubjectTeacher(html, ba);
        SubjectTeacher css5 = new SubjectTeacher(css, ba);
        SubjectTeacher js5 = new SubjectTeacher(js, ba);

        // course
        Course javaFullStack = new Course(1, "Java Full Stack", new SubjectTeacher[] { java1a, java1b },
                new Student[] { beou, phuong, thai });
        Course foundation = new Course(2, "Foundation Programing", new SubjectTeacher[] { html5, css5, js5 },
                new Student[] {});

        // class
        Class a = new Class(1, new Date[] {}, lab2, javaFullStack, java1a, new Checking[] {});
        Class b = new Class(2, new Date[] {}, lab2, foundation, html5, new Checking[] {});

        System.out.println(a.room.address);
        System.out.println(a.subjectTeacher.teacher.fullName);
        System.out.println(b.course.name);

        for (Student s : a.course.listStudents) {
            s.hello();
        }
    }
}

class Setter {
    
}

class Course {
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

class Class {
    int id;
    Date[] dates;
    Room room;
    Course course;
    SubjectTeacher subjectTeacher;
    Checking[] listCheckings;

    Class(int id, Date[] dates, Room room, Course course, SubjectTeacher subjectTeacher, Checking[] listCheckings) {
        this.id = id;
        this.dates = dates;
        this.room = room;
        this.course = course;
        this.subjectTeacher = subjectTeacher;
        this.listCheckings = listCheckings;
    }
}

class Student {
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

class Teacher {
    int id;
    String fullName;
    Subject[] listSubjects;

    Teacher(int id, String fullName, Subject[] listSubjects) {
        this.id = id;
        this.fullName = fullName;
        this.listSubjects = listSubjects;
    }
}

class Subject {
    int id;
    String name;

    Subject(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Room {
    String name;
    String address;

    Room(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

class SubjectTeacher {
    Subject subject;
    Teacher teacher;

    SubjectTeacher(Subject subject, Teacher teacher) {
        this.subject = subject;
        this.teacher = teacher;
    }
}

class Checking {
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