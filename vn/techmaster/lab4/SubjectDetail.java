package vn.techmaster.lab4;

import java.util.Locale;
import java.util.Scanner;

public class SubjectDetail {
    /**
     * Hiển thị nội dung hướng dẫn sử dụng chức năng
     * 
     * @param validate
     * @param s
     */
    private static void print(boolean validate, String s) {
        System.out.println("\nThông tin môn học!!!\n");
        System.out.println("1. Toàn bộ môn học");
        System.out.println("2. Tìm kiếm môn học");
        System.out.println("\nNhập 'b' để trở về menu trước!\n");

        if (!validate) {
            System.out.println("'" + s + "' không hợp lệ!\n");
        }

        System.out.print("Chọn thao tác: ");
    }

    private static void all(Scanner in) {
        if (Subject.getTotal() <= 0) {
            System.out.println("\nChưa có môn học... @@");
            System.out.print("\nBấm 'Enter' để tiếp tục...");
            in.nextLine();
            return;
        }

        System.out.printf("\n%4s  %-50s\n", "ID", "Tên môn học");
        for (int i = 0; i < Subject.getTotal(); i++) {
            Main.subjects[i].print();
        }
        System.out.printf("\nBấm 'Enter' để tiếp tục...");
        in.nextLine();
    }

    private static void searh(Scanner in) {
        System.out.println("\nTìm kiếm môn học theo tên!!!\n");
        System.out.println("Nhập 'c' để hủy bỏ.\n");
        System.out.print("Tên môn học: ");
        Locale l = new Locale("vi-VN");
        String s = in.nextLine().toLowerCase(l);
        int count = 0;

        if (s.equalsIgnoreCase("c")) {
            System.out.println("\nĐã hủy\n");
            return;
        }

        System.out.printf("\n%4s  %-50s\n", "ID", "Tên môn học");

        for (Subject sj : Main.subjects) {
            if (sj == null) {
                break;
            }

            if (sj.getName().toLowerCase(l).contains(s)) {
                sj.print();
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
                    searh(in);
                    break;

                default:
                    validate = false;
            }
        } while (!quit);
    }
}
