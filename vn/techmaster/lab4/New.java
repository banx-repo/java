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
        System.out.println("2. Thêm môn học");
        System.out.println("3. Thêm giảng viên");
        System.out.println("4. Thêm phòng học");
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

            if (Pattern.matches(
                    "[a-zA-z àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ]{6,30}",
                    s)) {
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
     * Thêm môn học
     * 
     * @param in
     */
    private static void newSubject(Scanner in) {
        String s = "";

        boolean validate = true;

        while (true) {
            System.out.println("\nThêm môn học mới!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("'" + s + "' không hợp lệ!\n");
            }

            System.out.printf("Tên môn học (3 - 50 ký tự và số, không bao gồm ký tự đặc biệt): ");
            s = in.nextLine().trim();

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy");
                return;
            }

            if (Pattern.matches(
                    "[a-zA-z0-9 àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ]{3,50}",
                    s)) {
                break;
            }

            validate = false;
        }

        int index = Subject.getTotal();
        int id = Subject.getNewId();

        Main.subjects[index] = new Subject(id, s);
        System.out.println("\nĐã thêm môn học thành công!");
        System.out.print("\nBấm 'Enter' để tiếp tục....");
        in.nextLine();
    }

    private static void newTeacher(Scanner in) {
        String s = "";
        String fullName = "";
        Subject[] listSubjects;

        boolean validate = true;

        while (true) {
            System.out.println("\nThêm giảng viên mới!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("'" + s + "' không hợp lệ!\n");
            }

            System.out.printf("Tên giảng viên (6 - 30 ký tự không bao gồm số và ký tự đặc biệt): ");
            s = in.nextLine().trim();

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy");
                return;
            }

            if (Pattern.matches(
                    "[a-zA-z àáãạảăắằẳẵặâấầẩẫậèéẹẻẽêềếểễệđìíĩỉịòóõọỏôốồổỗộơớờởỡợùúũụủưứừửữựỳỵỷỹýÀÁÃẠẢĂẮẰẲẴẶÂẤẦẨẪẬÈÉẸẺẼÊỀẾỂỄỆĐÌÍĨỈỊÒÓÕỌỎÔỐỒỔỖỘƠỚỜỞỠỢÙÚŨỤỦƯỨỪỬỮỰỲỴỶỸÝ]{6,30}",
                    s)) {
                fullName = s;
                break;
            }

            validate = false;
        }

        while (true) {
            System.out.println("\nThêm giảng viên mới!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("'" + s + "' không hợp lệ!\n");
            }

            System.out.printf("Danh sách môn dạy (Id môn học, phân tách bởi dấu ' '): ");
            s = in.nextLine().trim().replaceAll("\\s+", " ");

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy");
                return;
            }

            if (Pattern.matches("[0-9 ]{1,}", s)) {
                try {
                    String[] arr = s.split(" ");
                    int[] listSubjectsId = new int[arr.length];
                    listSubjects = new Subject[arr.length];

                    loop: for (int i = 0, j = 0; i < arr.length; i++) {
                        int id = Integer.parseInt(arr[i]);

                        if (id <= 0 || id > Subject.getTotal()) {
                            System.out.printf("Mã môn học '%d' không tồn tại!", id);
                            throw new Exception();
                        }

                        for (int el : listSubjectsId) {
                            if (el == 0) {
                                break;
                            }

                            if (el == id) {
                                continue loop;
                            }
                        }

                        listSubjectsId[j] = id;
                        listSubjects[j] = Main.subjects[id - 1];
                        j++;
                    }

                    break;
                } catch (Exception e) {
                    System.out.println(e);
                    validate = false;
                }
            }

            validate = false;
        }

        int index = Teacher.getTotal();
        int id = Teacher.getNewId();

        Main.teachers[index] = new Teacher(id, fullName, listSubjects);
        System.out.println("\nĐã thêm giảng viên thành công!");
        System.out.print("\nBấm 'Enter' để tiếp tục....");
        in.nextLine();
    }

    private static void newRoom(Scanner in) {
        String s = "";
        String name = "";
        String address = "";

        boolean validate = true;

        while (true) {
            System.out.println("\nThêm phòng học mới!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("'" + s + "' không hợp lệ!\n");
            }

            System.out.print("Tên lớp học (3 - 10 ký tự không dấu và số, không bao gồm ký tự đặc biệt): ");

            s = in.nextLine().trim().replaceAll("\\s+", " ");

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy");
                return;
            }

            if (Pattern.matches("[a-zA-Z0-9 ]{3,10}", s)) {
                name = s;
                validate = true;
                break;
            }

            validate = false;
        }

        while (true) {
            System.out.println("\nThêm phòng học mới!!!\n");
            System.out.println("Nhập 'c' để hủy bỏ\n");

            if (!validate) {
                System.out.println("'" + s + "' không hợp lệ!\n");
            }

            System.out.print("Địa chỉ (10 - 100 ký tự): ");

            s = in.nextLine().trim().replaceAll("\\s+", " ");

            if (s.equalsIgnoreCase("c")) {
                System.out.println("\nĐã hủy");
                return;
            }

            if (Pattern.matches(".{10,50}", s)) {
                address = s;
                validate = true;
                break;
            }

            validate = false;
        }

        int index = Room.getTotal();
        int id = Room.getNewId();

        Main.rooms[index] = new Room(id, name, address);
        System.out.println("\nĐã thêm phòng học thành công!");
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
                    newSubject(in);
                    break;

                case 3:
                    newTeacher(in);
                    break;

                case 4:
                    newRoom(in);
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
