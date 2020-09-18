package vn.techmaster.lab4;

import java.util.Scanner;

public class SubjectTeacherDetail {
    /**
     * Hiển thị nội dung hướng dẫn sử dụng chức năng
     * 
     * @param validate
     * @param s
     */
    private static void print(boolean validate, String s) {
        System.out.println("\nThông tin giảng viên bộ môn!!!\n");
        System.out.println("1. Toàn bộ các giảng viên bộ môn");
        System.out.println("2. ---");
        System.out.println("3. ---");
        System.out.println("\nNhập 'b' để trở về menu trước!\n");

        if (!validate) {
            System.out.println("'" + s + "' không hợp lệ!\n");
        }

        System.out.print("Chọn thao tác: ");
    }

    private static void all(Scanner in) {
        if (SubjectTeacher.getTotal() <= 0) {
            System.out.println("\nChưa có giảng viên bộ môn nào... @@");
            System.out.print("\nBấm 'Enter' để tiếp tục...");
            in.nextLine();
            return;
        }

        System.out.printf("\n%4s  %4s  %-30s\n", "ID", "Môn học", "Giảng viên");

        for (int i = 0; i < SubjectTeacher.getTotal(); i++) {
            Main.subjectTeachers[i].print();
        }

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
                    System.out.println("---");
                    break;

                case 3:
                    System.out.println("---");
                    break;

                default:
                    validate = false;
            }
        } while (!quit);
    }
}
