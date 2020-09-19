package vn.techmaster.lab4;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CourseDetail {
    /**
     * Hiển thị nội dung hướng dẫn sử dụng chức năng
     * 
     * @param validate
     * @param s
     */
    private static void print(boolean validate, String s) {
        System.out.println("\nThông tin khóa học!!!\n");
        System.out.println("1. Toàn bộ khóa học");
        System.out.println("2. Chi tiết khóa học");
        System.out.println("3. Tìm kiếm khóa học");
        System.out.println("\nNhập 'b' để trở về menu trước!\n");

        if (!validate) {
            System.out.println("'" + s + "' không hợp lệ!\n");
        }

        System.out.print("Chọn thao tác: ");
    }

    private static void all(Scanner in) {
        if (Course.getTotal() <= 0) {
            System.out.println("\nChưa có khóa học... @@");
            System.out.print("\nBấm 'Enter' để tiếp tục...");
            in.nextLine();
            return;
        }

        System.out.printf("\n%4s  %-50s  %s\n", "ID", "Tên khóa học", "Số môn");
        for (int i = 0; i < Course.getTotal(); i++) {
            Main.courses[i].print();
        }
        System.out.println();
        System.out.printf("\nBấm 'Enter' để tiếp tục...");
        in.nextLine();
    }

    private static void details(Scanner in) {
        boolean validate = true;

        while (true) {
            System.out.println("\nChi tiết khóa học!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("Mã khóa học không hợp lệ hoặc không tồn tại!\n");
            }

            System.out.print("Mã khóa học: ");
            String s = in.nextLine();

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy\n");
                return;
            }

            if (!Pattern.matches("[0-9]{1,}", s) || Integer.parseInt(s) <= 0
                    || Integer.parseInt(s) > Course.getTotal()) {
                validate = false;
                continue;
            }

            Main.courses[Integer.parseInt(s) - 1].printDetail();
            System.out.print("\nBấm 'Enter' để tiếp tục...");
            in.nextLine();
            break;
        }
    }

    public static void search(Scanner in) {
        Locale l = new Locale("vi-VN");

        while (true) {
            System.out.println("\nTìm kiếm khóa học!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            System.out.print("Tên khóa học: ");
            String s = in.nextLine().trim().replaceAll("\\s+", " ");

            System.out.printf("\n%4s  %-50s  %s\n", "ID", "Tên khóa học", "Số môn");
            for (Course c : Main.courses) {
                if (c == null) {
                    break;
                }

                if (c.getName().toLowerCase(l).contains(s)) {
                    c.print();
                }
            }

            System.out.print("\nBấm 'Enter' để tiếp tục...");
            in.nextLine();
            break;
        }
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
                    details(in);
                    break;

                case 3:
                    search(in);
                    break;

                default:
                    validate = false;
            }
        } while (!quit);
    }
}
