package vn.techmaster.lab7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Account {
    private Scanner in;
    private String id;
    private double balance;

    private static ArrayList<String> ids = new ArrayList<>();

    String getId() {
        return this.id;
    }

    double getBalance() {
        return this.balance;
    }

    private boolean setId() {
        String s;
        String err = null;

        while (true) {
            System.out.print("Số tài khoản: ");

            if (err != null) {
                System.out.println(err);
            }

            s = this.in.nextLine().replaceAll("\\s+", "");

            if ("c".equalsIgnoreCase(s)) {
                return false;
            }

            if (Pattern.matches("[0-9]{9}", s)) {
                err = "Số tài khoản không hợp lệ!";
            }

            if (ids.contains(s)) {
                err = "Tài khoản đã tồn tại!";
            }

            break;
        }

        this.id = s;
        ids.add(s);
        return true;
    }

    private boolean setBalance() {
        String s;
        Double d;
        String err = null;

        while (true) {
            System.out.print("Số dư ban đầu: ");
            s = this.in.nextLine();

            if (err != null) {
                System.out.println(err);
            }

            if ("c".equalsIgnoreCase(s)) {
                return false;
            }

            try {
                d = Double.parseDouble(s);
            } catch (InputMismatchException e) {
                err = "Số dư không hợp lệ!";
                continue;
            } catch (Exception e) {
                return false;
            }

            break;
        }

        this.balance = d;
        return true;
    }

    Account(Scanner in) {
        this.in = in;
        if (!this.setId() || !this.setBalance()) {
            throw new IllegalArgumentException();
        }
    }

    void deposit(double value) {
        this.balance += value;
    }

    void reduceBalance(double value) throws IllegalArgumentException {
        if (value > this.balance) {
            throw new IllegalArgumentException();
        }

        this.balance -= value;
    }
}
