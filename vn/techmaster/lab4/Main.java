package vn.techmaster.lab4;

import java.util.Date;

public class Main {
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
