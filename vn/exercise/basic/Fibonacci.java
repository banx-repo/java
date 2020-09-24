package vn.exercise.basic;

import java.util.Scanner;
import vn.banx.lib.ClearScreen;

class Fibonacci {
    public static void main(String[] args) {
        long a = 0;
        long b = 1;
        long c;

        Scanner in = new Scanner(System.in);
        String s;
        int i;
        String err = null;

        while (true) {
            ClearScreen.clear();

            System.out.println("The program prints the sequence of fibonacci numbers from 0 to N!!!");
            System.out.println("Enter 'q' to quit!");

            if (err != null) {
                System.out.println(err);
            }

            System.out.print("Enter N (must be greater than 1): ");

            s = in.nextLine();
            if (s.equalsIgnoreCase("q")) {
                System.out.println("Have fun! Goodbye...");
                break;
            }

            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                err = "'" + s + "' is illegal!";
                continue;
            }

            if (i < 2) {
                err = "N must be greater than 1! You enter '" + s + "'";
                continue;
            }

            System.out.print(a + " " + b);

            for (int j = 0; j <= i - 2; j++) {
                c = a + b;
                a = b;
                b = c;
                System.out.print(" " + c);
            }

            err = null;
            a = 0;
            b = 1;
            System.out.println();
            System.out.print("Press 'Enter' to continue...");
            in.nextLine();
        }

        in.close();
    }
}