package vn.techmaster.lab4;

import java.util.Scanner;

public class Show {
    /**
     * Hiển thị nội dung hướng dẫn sử dụng chức năng
     * 
     * @param validate
     * @param s
     */
    private static void print(boolean validate, String s) {
        System.out.println("\nXem thông tin!!!\n");
        System.out.println("1. Thông tin học viên");
        System.out.println("2. Thông tin môn học");
        System.out.println("3. Thông tin giảng viên");
        System.out.println("4. Thông tin phòng học");
        System.out.println("5. Thông tin giảng viên bộ môn");
        System.out.println("6. Thông tin khóa học");
        System.out.println("7. Thông tin lớp học");
        System.out.println("\nNhập 'b' để trở về menu chính!\n");

        if (!validate) {
            System.out.println("'" + s + "' không hợp lệ!\n");
        }

        System.out.print("Chọn thao tác: ");
    }

    public static void choose(Scanner in) {
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
                    StudentDetail.show(in);
                    break;

                case 2:
                    SubjectDetail.show(in);
                    break;

                case 3:
                    TeacherDetail.show(in);
                    break;

                case 4:
                    RoomDetails.show(in);
                    break;

                case 5:
                    SubjectTeacherDetail.show(in);
                    break;

                case 6:
                    CourseDetail.show(in);
                    break;

                case 7:
                    System.out.println("\nChức năng xem thông tin lớp học đang xây dựng\n");
                    break;

                default:
                    validate = false;
            }
        } while (!quit);
    }
}
