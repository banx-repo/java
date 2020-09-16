package vn.test;

import java.util.Arrays;

public class OnLab {
    int[] add(int[] arr, int value) {
        int length = arr.length;
        int[] result = new int[length + 1];
        for (int i = 0; i < length; i++) {
            result[i] = arr[i];
        }
        result[length] = value;
        return result;
    }

    int[] insert(int[] arr, int value, int index) {
        int length = arr.length;

        if (index < 0 || index > length) {
            System.out.println("Invalid Index");
            return arr;
        }

        int[] result = new int[length + 1];

        for (int i = 0, j = 0; j < length + 1; i++, j++) {
            if (j == index && i == j) {
                result[j] = value;
                i--;
            } else {
                result[j] = arr[i];
            }
        }

        return result;
    }

    int[] remove(int arr[], int index) {
        if (index < 0 || index > arr.length - 1) {
            System.out.println("Invalid Index");
            return arr;
        }

        int[] result = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (i == index && i == j) {
                j--;
                continue;
            }

            result[j] = arr[i];
        }

        return result;
    }

    void printMatrix() {
        int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7 }, { 8, 9 }, { 10 } };

        for (int[] i : arr) {
            for (int j : i) {
                System.out.printf("%2d ", j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        OnLab ol = new OnLab();
        System.out.println(Arrays.toString(ol.add(new int[] { 1, 2, 3 }, 4)));

        System.out.println(Arrays.toString(ol.insert(new int[] { 1, 2, 4 }, 3, 3)));

        System.out.println(Arrays.toString(ol.remove(new int[] { 1, 2, 3, 4 }, 3)));

        ol.printMatrix();

        WEEKDAY mon = WEEKDAY.MONDAY;
        System.out.println(mon);
    }
}

enum WEEKDAY {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}