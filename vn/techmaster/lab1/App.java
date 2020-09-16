package vn.techmaster.lab1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        double p;
        double r;
        short n;
        double m;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Chương trình tính lãi suất hàng tháng!!!");
        System.out.println("Vui lòng nhập số tiền, lãi suất (tính theo năm), và kỳ hạn (tính theo năm)!!!");

        do {
            System.out.print("Nhập số tiền: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Số tiền không hợp lệ!!!");
                System.out.println("Số tiền phải lớn hơn 1.000.000 đ và tối đa 1.000.000.000 đ!!!");
                System.out.print("Vui lòng nhập lại: ");

                scanner.nextDouble();
            }

            p = scanner.nextDouble();
        } while (p < 1000000 || p > 1000000000);

        do {
            System.out.print("Nhập lãi suất: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Lãi suất không hợp lệ!!!");
                System.out.println("Lãi suất phải lớn hơn 0% và tối đa 30% / năm!!!");
                System.out.print("Vui lòng nhập lại: ");

                scanner.nextDouble();
            }

            r = scanner.nextDouble() / 100 / 12;
        } while (r <= 0 || r > 0.025);

        do {
            System.out.print("Nhập kỳ hạn vay: ");

            while (!scanner.hasNextDouble()) {
                System.out.println("Kỳ hạn không hợp lệ!!!");
                System.out.println("Kỳ hạn phải lớn hơn hoặc bằng 1 năm và tối đa 15 năm!!!");
                System.out.print("Vui lòng nhập lại: ");

                scanner.nextShort();
            }

            n = (short) (scanner.nextShort() * 12);
        } while (n < 12 || n > 180);

        scanner.close();

        m = p * r * Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1);

        System.out.printf("Tiền lãi hàng tháng phải trả là: %.4fđ\n", m);
    }
}
