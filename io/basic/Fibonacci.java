package io.basic;

public class Fibonacci {
    void print(int n) {
        int a = 0;
        int b = 1;
        int c;

        if (n <= 0) {
            System.out.println("N phải lớn hơn 0. Nhận vào: " + n);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(a + " ");
                continue;
            }

            if (i == 1) {
                System.out.print(b + " ");
                continue;
            }

            c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
        }

        System.out.println();
    }
}

class App {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        f.print(10);
    }
}