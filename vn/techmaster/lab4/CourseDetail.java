package vn.techmaster.lab4;

import java.util.Scanner;

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
                    System.out.println("\nChức năng xem thông tin chi tiết khóa học đang xây dựng\n");
                    break;

                case 3:
                    System.out.println("\nChức năng tìm kiếm khóa học đang xây dựng\n");
                    break;

                default:
                    validate = false;
            }
        } while (!quit);
    }
}
