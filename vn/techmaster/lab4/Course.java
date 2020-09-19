package vn.techmaster.lab4;

public class Course {
    private static int count = 1;
    private int id;
    private String name;
    private SubjectTeacher[] listSubjectTeachers;
    private Student[] listStudents;

    Course(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Course(int id, String name, SubjectTeacher[] listSubjectTeachers) {
        this(id, name);
        this.listSubjectTeachers = listSubjectTeachers;
    }

    Course(int id, String name, SubjectTeacher[] listSubjectTeachers, Student[] listStudents) {
        this(id, name, listSubjectTeachers);
        this.listStudents = listStudents;
    }

    void print() {
        System.out.printf("%4s  %-50s  %s\n", this.id, this.name, this.listSubjectTeachers.length);
    }

    void printDetail() {
        System.out.printf("\nKhóa học %s\n\n", this.name);

        System.out.println("Giảng viên bộ môn:\n");
        System.out.printf("%4s  %-30s  %s\n", "ID", "Môn học", "Giảng viên");
        for (SubjectTeacher st : listSubjectTeachers) {
            st.print();
        }

        System.out.println("\nHọc viên đăng ký:\n");
        System.out.printf("%4s  %4s  %s\n", "ID", "Tuổi", "Họ tên");
        for (Student sd : listStudents) {
            sd.print();
        }
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

    SubjectTeacher[] getSubjectTeacher() {
        return this.listSubjectTeachers;
    }

    void setSubjectTeacher(SubjectTeacher[] listSubjectTeachers) {
        this.listSubjectTeachers = listSubjectTeachers;
    }

    Student[] getStudent() {
        return this.listStudents;
    }

    void setStudent(Student[] listStudents) {
        this.listStudents = listStudents;
    }

    void addSubjectTeacher(SubjectTeacher subjectTeacher) {
        System.out.println("Add Subject Teacher");
    }

    void removeSubjectTeacher(int id) {
        System.out.println("Remove Subject Teacher");
    }

    void addStudent(Student student) {
        System.out.println("Add Student");
    }

    void removeStudent(Student student) {
        System.out.println("Remove Student");
    }
}
