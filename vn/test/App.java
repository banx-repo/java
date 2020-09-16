package vn.test;

final class Employee {
    final String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Overrding
    public String toString() {
        return "Hello, my name is " + this.name;
    }
}

public class App {
    String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    boolean isPalindrome(String s) {
        return reverseString(s).equals(s);
    }

    String capitalize(String s) {
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
        }

        return String.join(" ", arr);
    }

    String reverseEach(String s) {
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = reverseString(arr[i]);
        }

        return String.join(" ", arr);
    }

    String toggleEach(String s) {
        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toUpperCase();
            arr[i] = arr[i].substring(0, 1).toLowerCase() + arr[i].substring(1);
        }

        return String.join(" ", arr);
    }

    String reverseToggle(String s) {
        return toggleEach(reverseEach(s));
    }

    public static void main(String[] args) {
        Employee e = new Employee("Ba");
        System.out.println(e);
        
        String s = "Hello World!";
        App a = new App();
        System.out.println(a.reverseString(s));
        System.out.println(a.isPalindrome(s));
        System.out.println(a.capitalize(s));
        System.out.println(a.reverseEach(s));
        System.out.println(a.toggleEach(s));
        System.out.println(a.reverseToggle(s));
    }
}