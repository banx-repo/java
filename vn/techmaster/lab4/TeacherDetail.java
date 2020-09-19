package vn.techmaster.lab4;

import java.util.Locale;
import java.util.Scanner;

public class TeacherDetail {
    /**
     * Hiển thị nội dung hướng dẫn sử dụng chức năng
     * 
     * @param validate
     * @param s
     */
    private static void print(boolean validate, String s) {
        System.out.println("\nThông tin giảng viên!!!\n");
        System.out.println("1. Toàn bộ giảng viên");
        System.out.println("2. Tìm kiếm giảng viên theo tên");
        System.out.println("3. Tìm kiếm giảng viên theo bộ môn");
        System.out.println("\nNhập 'b' để trở về menu trước!\n");

        if (!validate) {
            System.out.println("'" + s + "' không hợp lệ!\n");
        }

        System.out.print("Chọn thao tác: ");
    }

    private static void all(Scanner in) {
        if (Teacher.getTotal() <= 0) {
            System.out.println("\nChưa có giảng viên... @@");
            System.out.print("\nBấm 'Enter' để tiếp tục...");
            in.nextLine();
            return;
        }

        System.out.printf("\n%4s  %-30s  %s\n", "ID", "Họ và tên", "Các môn dạy");
        for (int i = 0; i < Teacher.getTotal(); i++) {
            Main.teachers[i].print();
        }
        System.out.printf("\nBấm 'Enter' để tiếp tục...");
        in.nextLine();
    }

    private static void searhByName(Scanner in) {
        System.out.println("\nTìm kiếm giảng viên theo tên!!!\n");
        System.out.println("Nhập 'c' để hủy bỏ.\n");
        System.out.print("Tên giảng viên: ");
        Locale l = new Locale("vi-VN");
        String s = in.nextLine().toLowerCase(l);
        int count = 0;

        if (s.equalsIgnoreCase("c")) {
            System.out.println("\nĐã hủy\n");
            return;
        }

        System.out.printf("\n%4s  %-30s  %s\n", "ID", "Họ tên", "Bộ môn");

        for (Teacher t : Main.teachers) {
            if (t == null) {
                break;
            }

            if (t.getFullName().toLowerCase(l).contains(s)) {
                t.print();
                count++;
            }
        }

        System.out.printf("\nTổng cộng: %d\n", count);

        System.out.printf("\nBấm 'Enter' để tiếp tục...");
        in.nextLine();
    }

    private static void searhBySubject(Scanner in) {
        System.out.println("\nTìm kiếm giảng viên theo bộ môn!!!\n");
        System.out.println("Nhập 'c' để hủy bỏ.\n");
        System.out.print("Tên môn học: ");
        Locale l = new Locale("vi-VN");
        String s = in.nextLine().toLowerCase(l);
        int count = 0;

        if (s.equalsIgnoreCase("c")) {
            System.out.println("\nĐã hủy\n");
            return;
        }

        System.out.printf("\n%4s  %-30s  %s\n", "ID", "Họ tên", "Bộ môn");

        for (Teacher t : Main.teachers) {
            if (t == null) {
                break;
            }

            if (t.sjToString().toLowerCase(l).contains(s)) {
                t.print();
                count++;
            }
        }

        System.out.printf("\nTổng cộng: %d\n", count);

        System.out.printf("\nBấm 'Enter' để tiếp tục...");
        in.nextLine();
    }

    static void show(Scanner in) {
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
                    all(in);
                    break;

                case 2:
                    searhByName(in);
                    break;

                case 3:
                    searhBySubject(in);
                    break;

                default:
                    validate = false;
            }
        } while (!quit);
    }
}
