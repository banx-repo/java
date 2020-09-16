package vn.techmaster.lab2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] arr = { 1, 24, 5, 7, 2, 67, 8, 3, 46, 6, 7, 45, 768, 45, 6 };
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {
            temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                    temp = arr[i];
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
