package vn.techmaster.lab5.person;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Teacher extends Person {
    public static int count = 1;
    private static String pf = "%-2s %-20s %-10s %-12s %-7s %-10s %-7s %s\n";

    private int id;
    private Class classCode;
    private double salary;
    private int hour;

    public static int getTotalId() {
        return count - 1;
    }

    private int getNewId() {
        return count++;
    }

    // getter
    public int getId() {
        return this.id;
    }

    private Class getClassCode() {
        return this.classCode;
    }

    private double getSalary() {
        return this.salary;
    }

    private int getHour() {
        return this.hour;
    }

    // setter

    private boolean setClassCode(String s) {
        if (s.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        if (Pattern.matches("[ghiklmGHIKLM]{1}", s)) {
            this.classCode = Class.valueOf(s.toUpperCase());
            return true;
        }

        System.out.println("'" + s + "' không hợp lệ!");
        return false;
    }

    private boolean setSalary(String s) {
        if (s.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        try {
            this.salary = Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            System.out.println("'" + s + "' không hợp lệ!");
            return false;
        }
    }

    private boolean setHour(String s) {
        if (s.equalsIgnoreCase("c")) {
            cancelConstructor = true;
            return true;
        }

        try {
            this.hour = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected boolean create() {
        super.create();

        while (!cancelConstructor) {
            System.out.print("Mã lớp dạy (GHIKLM): ");
            if (setClassCode(in.nextLine().trim())) {
                break;
            }
        }

        while (!cancelConstructor) {
            System.out.print("Lương dạy / giờ: ");
            if (setSalary(in.nextLine())) {
                break;
            }
        }

        while (!cancelConstructor) {
            System.out.print("Giờ dạy / tháng: ");
            if (setHour(in.nextLine())) {
                break;
            }
        }

        return !cancelConstructor;
    }

    Teacher(Scanner in) {
        System.out.println();
        System.out.println("Tạo hồ sơ giảng viên mới!");
        System.out.println("Nhập 'C' để hủy bỏ.");

        System.out.println();
        System.out.println("ID: " + (getTotalId() + 1));

        if (!create()) {
            throw new IllegalArgumentException("Đã hủy...");
        }

        this.id = getNewId();
    }

    @Override
    public void print() {
        System.out.printf(pf, this.getId(), this.getFullName(), this.getGender(), this.getBirthday(),
                this.getClassCode(), this.getSalary(), this.getHour(), this.getAddress());
    }

    public static void printHeader() {
        System.out.printf(pf, "ID", "Họ tên", "Giới tính", "Ngày sinh", "Lớp dạy", "Lương/giờ", "Giờ dạy", "Địa chỉ");
    }

    public double payroll() {
        if (classCode.ordinal() <= 4) {
            return salary * hour;
        }

        return salary * hour + 200000;
    }
}
