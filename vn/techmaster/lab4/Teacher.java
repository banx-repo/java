package vn.techmaster.lab4;

public class Teacher {
    private static int count = 1;
    private int id;
    private String fullName;
    private Subject[] listSubjects;

    Teacher(int id, String fullName, Subject[] listSubjects) {
        this.id = id;
        this.fullName = fullName;
        this.listSubjects = listSubjects;

        for (Subject sj : listSubjects) {
            Main.subjectTeachers[SubjectTeacher.getTotal()] = new SubjectTeacher(SubjectTeacher.getNewId(), sj, this);
        }
    }

    void print() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Subject sj : listSubjects) {
                sb.append(sj.getName() + ", ");
            }
            System.out.printf("%4s  %-30s  %s\n", this.id, this.fullName, sb);
        } catch (Exception e) {
            System.out.println("LoL");
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

    String sjToString() {
        StringBuilder s = new StringBuilder();

        for (Subject sj : this.listSubjects) {
            if (sj == null) {
                break;
            }

            s.append(sj.getName());
        }

        return s.toString();
    }
}
