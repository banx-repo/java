package vn.algorithm.recursion;

public class Main {
    public static int find(int[] a, int x, int i) {
        if (i >= a.length) {
            return -1;
        } else {
            return a[i] == x ? i : find(a, x, i + 1);
        }
    }

    public static int sumAll(int[] a, int i) {
        return i >= a.length ? 0 : a[i] + sumAll(a, i + 1);
    }

    public static int sumRange(int[] a, int start, int end) {
        return start >= a.length || start > end ? 0 : a[start] + sumRange(a, start + 1, end);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(find(a, 6, 0));
        System.out.println(sumAll(a, 0));
        System.out.println(sumRange(a, 6, 1));
    }
}
