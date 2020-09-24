package vn.exercise.basic;

import java.util.Scanner;
import vn.lib.ClearScreen;

class PrimeNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s;
        int i;
        String err = null;

        while (true) {
            ClearScreen.clear();

            System.out.println("This is a program that checks for prime numbers!!!");
            System.out.println("The functions of the program:");
            System.out.println("1. Checks if a number is prime");
            System.out.println("2. Print out the sequence of prime numbers");
            System.out.println("Enter 'q' to quit!");

            if (err != null) {
                System.out.println(err);
            }

            System.out.print("Please select the function: ");
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

            err = null;

            switch (i) {
                case 1:
                    checkPrime(in);
                    break;

                case 2:
                    printPrime(in);
                    break;

                default:
                    err = "'" + i + "' is invalid function!";
            }
        }

        in.close();
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void checkPrime(Scanner in) {
        String s;
        int i;
        String err = null;

        while (true) {
            ClearScreen.clear();

            System.out.println("1. Check if a number is prime");
            System.out.println("Enter 'b' to return to the main menu");

            if (err != null) {
                System.out.println(err);
            }

            System.out.print("Enter the number N: ");
            s = in.nextLine();

            if (s.equalsIgnoreCase("b")) {
                return;
            }

            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                err = "'" + s + "' is illegal!";
                continue;
            }

            if (i < 0) {
                err = "N must be greater than 0! You enter: '" + i + "'";
                continue;
            }

            System.out.println(isPrime(i) ? i + " is prime number!" : i + " is not prime number!");
            err = null;
            System.out.print("Press 'Enter' to continue...");
            in.nextLine();
        }
    }

    public static void printPrime(Scanner in) {
        String s;
        int i;
        int total = 0;
        String err = null;

        while (true) {
            ClearScreen.clear();

            System.out.println("2. Print out the sequence of prime numbers");
            System.out.println("Enter 'b' to return to the main menu");

            if (err != null) {
                System.out.println(err);
            }

            System.out.print("Enter the number N: ");
            s = in.nextLine();

            if (s.equalsIgnoreCase("b")) {
                return;
            }

            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                err = "'" + s + "' is illegal!";
                continue;
            }

            if (i < 0) {
                err = "N must be greater than 0! You enter: '" + i + "'";
                continue;
            }

            for (int j = 0; j <= i; j++) {
                if (isPrime(j)) {
                    System.out.print(j + " ");
                    total++;
                }
            }

            System.out.println();
            System.out.println("There are a total of " + total + " primes between 0 and " + i);

            err = null;
            System.out.print("Press 'Enter' to continue...");
            in.nextLine();
        }
    }
}
