package vn.techmaster.lab5.person;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Student> students = new ArrayList<Student>();
    public static ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;

        System.out.println();
        System.out.println("Demo quản lý sinh viên - giảng viên!!!");
        System.out.println("1. Quản lý sinh viên");
        System.out.println("2. Quản lý giảng viên");

        System.out.println();
        System.out.println("Nhập số chọn chức năng muốn thực hiện");
        System.out.println("Nhập 'q' để thoát");

        main: while (true) {
            System.out.print("Chọn chức năng: ");
            s = in.nextLine();

            switch (s) {
                case "1":
                    studentManager(in);
                    break;
                case "2":
                    teacherManager(in);
                    break;
                case "q":
                    System.out.println("Goodbye...");
                    break main;
                default:
                    System.out.println("'" + s + "' không hợp lệ!");
            }
        }

        in.close();
    }

    public static void studentManager(Scanner in) {
        String s;

        System.out.println();
        System.out.println("Chức năng quản lý sinh viên!!!");
        System.out.println("1. Thêm hồ sơ sinh viên");
        System.out.println("2. Xem danh sách sinh viên");

        System.out.println();
        System.out.println("Nhập số chọn chức năng muốn thực hiện");
        System.out.println("Nhập 'b' để trở về Menu chính");

        main: while (true) {
            System.out.print("Chọn chức năng: ");
            s = in.nextLine();

            switch (s) {
                case "1":
                    try {
                        students.add(new Student(in));
                        System.out.println("Đã tạo thành công...");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    Student.printHeader();
                    for (Student student : students) {
                        if (student == null) {
                            break;
                        }
                        student.print();
                    }
                    System.out.print("Bấm 'Enter' để tiếp tục...");
                    in.nextLine();
                    break;

                case "b":
                    System.out.println("Trở về Menu chính...");
                    break main;

                default:
                    System.out.println("'" + s + "' không hợp lệ!");
            }
        }
    }

    public static void teacherManager(Scanner in) {
        String s;

        System.out.println();
        System.out.println("Chức năng quản lý giảng viên!!!");
        System.out.println("1. Thêm hồ sơ giảng viên");
        System.out.println("2. Xem danh sách giảng viên");

        System.out.println();
        System.out.println("Nhập số chọn chức năng muốn thực hiện");
        System.out.println("Nhập 'b' để trở về Menu chính");

        main: while (true) {
            System.out.print("Chọn chức năng: ");
            s = in.nextLine();

            switch (s) {
                case "1":
                    try {
                        teachers.add(new Teacher(in));
                        System.out.println("Đã tạo thành công...");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    Teacher.printHeader();
                    for (Teacher teacher : teachers) {
                        if (teacher == null) {
                            break;
                        }
                        teacher.print();
                    }
                    System.out.print("Bấm 'Enter' để tiếp tục...");
                    in.nextLine();
                    break;

                case "b":
                    System.out.println("Trở về Menu chính...");
                    break main;

                default:
                    System.out.println("'" + s + "' không hợp lệ!");
            }
        }
    }
}
