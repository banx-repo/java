package io.basic;

public class Prime {
    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static void print(int n) {
        int total = 0;

        if (n < 0) {
            System.err.println("N phải lớn hơn bằng 0. Nhận vào: " + n);
            return;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                total++;
                System.out.println(i + " is prime number");
            }
        }

        System.out.println("Total: " + total);
    }

    public static void main(String[] args) {
        Prime.print(-11);
    }
}
