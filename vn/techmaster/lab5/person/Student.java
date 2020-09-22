package vn.techmaster.lab5.person;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Student extends Person {
    private static int count = 1;
    private static String pf = "%-2s %-8s %-4s %-20s %-9s %-10s %-20s %s\n";

    private int id;
    private String code;
    private float score;
    private String email;

    public static int getTotalId() {
        return count - 1;
    }

    private int getNewId() {
        return count++;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public float getScore() {
        return score;
    }

    public String getEmail() {
        return email;
    }

    // setter
    private boolean setScore(String score) {
        if (score.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        try {
            float f = Float.parseFloat(score);

            if (f >= 0 && f <= 10) {
                this.score = f;
                return true;
            }

            throw new Exception();
        } catch (Exception e) {
        }

        System.out.println("'" + score + "' không hợp lệ!");
        return false;
    }

    private boolean setEmail(String email) {
        if (email.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches("[[a-zA-Z0-9]+[._]?[a-zA-Z]+]+@[a-zA-Z]+.[a-zA-Z]+", email)) {
            this.email = email;
            return true;
        }

        System.out.println("'" + email + "' không hợp lệ!");
        return false;
    }

    @Override
    protected boolean create(Scanner in) {
        super.create(in);

        while (!cancelConstructor) {
            System.out.print("Điểm trung bình: ");
            if (setScore(in.nextLine())) {
                break;
            }
        }

        while (!cancelConstructor) {
            System.out.print("Email: ");
            if (setEmail(in.nextLine().replaceAll("\\s", ""))) {
                break;
            }
        }

        return !cancelConstructor;
    }

    boolean scholarship() {
        return this.getScore() >= 8;
    }

    Student(Scanner in) {
        System.out.println();
        System.out.println("Tạo hồ sơ học viên mới!");
        System.out.println("Nhập 'C' để hủy bỏ.");

        System.out.println();
        System.out.println("ID: " + (getTotalId() + 1));

        if (!create(in)) {
            throw new IllegalArgumentException("Đã hủy...");
        }

        this.id = getNewId();
        this.code = new StringBuilder().append(LocalDate.now().getYear()).append(LocalDate.now().getMonthValue())
                .append(String.format("%03d", id)).toString();
    }

    @Override
    public void print() {
        System.out.printf(pf, getId(), getCode(), getScore(), getFullName(), getGender(), getBirthday(), getEmail(),
                getAddress());
    }

    public static void printHeader() {
        System.out.printf(pf, "ID", "Mã SV", "Điểm", "Họ tên", "Giới tính", "Ngày sinh", "Email", "Địa chỉ");
    }
}
