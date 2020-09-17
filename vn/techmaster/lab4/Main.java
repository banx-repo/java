package vn.techmaster.lab4;

import java.util.Scanner;

public class Main {
    static Student[] students = new Student[1000];
    static Teacher[] teachers = new Teacher[50];
    static Subject[] subjects = new Subject[50];
    static Room[] rooms = new Room[20];
    static SubjectTeacher[] subjectTeachers = new SubjectTeacher[500];
    static Course[] courses = new Course[20];
    static Class[] classes = new Class[50];

    private static void print(boolean validate, String s) {
        System.out.println("\nChương trình quản lý lớp học Techmaster!!!\n");
        System.out.println("1. Xem dữ liệu");
        System.out.println("2. Thêm dữ liệu");
        System.out.println("3. Cập nhật dữ liệu");
        System.out.println("4. Xóa dữ liệu");
        System.out.println("\nNhập 'q' để thoát chương trình!\n");

        if (!validate) {
            System.out.println("'" + s + "' không hợp lệ!\n");
        }

        System.out.print("Chọn thao tác: ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int function = 0;
        String s = "";

        boolean quit = false;
        boolean validate = true;

        do {
            print(validate, s);
            s = in.nextLine();

            if (s.equalsIgnoreCase("q")) {
                System.out.println("Goodbye...");
                quit = true;
            }

            try {
                function = Integer.parseInt(s);
                validate = true;
            } catch (Exception e) {
                validate = false;
            }

            if (!validate) {
                continue;
            }

            switch (function) {
                case 1:
                    Show.choose(in);
                    break;

                case 2:
                    New.create(in);
                    break;

                case 3:
                    System.out.println("Cập nhật dữ liệu");
                    break;

                case 4:
                    System.out.println("Xóa dữ liệu");
                    break;

                default:
                    validate = false;
            }
        } while (!quit);

        in.close();
    }
}
