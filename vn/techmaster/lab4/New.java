package vn.techmaster.lab4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class New {
    /**
     * Hiển thị nội dung hướng dẫn sử dụng chức năng
     * 
     * @param validate
     * @param s
     */
    private static void print(boolean validate, String s) {
        System.out.println("\nThêm mới dữ liệu!!!\n");
        System.out.println("1. Thêm học viên");
        System.out.println("2. ---");
        System.out.println("3. ---");
        System.out.println("4. ---");
        System.out.println("5. ---");
        System.out.println("6. ---");
        System.out.println("7. ---");
        System.out.println("\nNhập 'b' để trở về menu chính!\n");

        if (!validate) {
            System.out.println("'" + s + "' không hợp lệ!\n");
        }

        System.out.print("Chọn thao tác: ");
    }

    /**
     * Thêm học viên mới
     * 
     * @param in
     */
    private static void newStudent(Scanner in) {
        String s = "";
        String fullName = "";
        int age = 0;

        boolean validate = true;

        while (true) {
            System.out.println("\nThêm học viên mới!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("'" + s + "' không hợp lệ!\n");
            }

            System.out.printf("Họ tên học viên (6 - 30 ký tự không bao gồm số và ký tự đặc biệt): ");
            s = in.nextLine().trim();

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy");
                return;
            }

            System.out.println(Pattern.matches("[a-zA-z ]", s));
            if (s.length() > 0 && Pattern.matches("[a-zA-z ]{6,30}", s)) {
                fullName = s;
                validate = true;
                break;
            }

            validate = false;
        }

        while (true) {
            System.out.println("\nThêm học viên mới!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("'" + s + "' không hợp lệ!\n");
            }

            System.out.print("Tuổi học viên (10 - 60 tuổi): ");
            s = in.nextLine();

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy");
                return;
            }

            try {
                age = Integer.parseInt(s);

                if (age >= 10 && age <= 60) {
                    validate = true;
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                validate = false;
            }
        }

        int index = Student.getTotal();
        int id = Student.getNewId();

        Main.students[index] = new Student(id, fullName, age);
        System.out.println("\nĐã thêm học viên thành công!");
        System.out.print("\nBấm 'Enter' để tiếp tục....");
        in.nextLine();
    }

    /**
     * Công cụ thêm mới dữ liệu.
     * 
     * @param in
     */
    public static void create(Scanner in) {
        int function = 0;
        String s = "";

        boolean quit = false;
        boolean validate = true;

        do {
            print(validate, s);
            s = in.nextLine();

            if (s.equalsIgnoreCase("b")) {
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
                    newStudent(in);
                    break;

                case 2:
                    System.out.println("---");
                    break;

                case 3:
                    System.out.println("---");
                    break;

                case 4:
                    System.out.println("---");
                    break;

                case 5:
                    System.out.println("---");
                    break;

                case 6:
                    System.out.println("---");
                    break;

                case 7:
                    System.out.println("---");
                    break;

                default:
                    validate = false;
            }
        } while (!quit);
    }
}
