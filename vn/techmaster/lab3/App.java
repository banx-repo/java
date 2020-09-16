package vn.techmaster.lab3;

import java.util.Arrays;

public class App {
    /**
     * Chèn phần tử vào cuối mảng, trả về mảng mới
     * 
     * @param arr   - mảng nguồn
     * @param value - giá trị cần thêm
     */
    int[] insert(int[] arr, int value) {
        int length = arr.length;

        int[] result = new int[length + 1];

        for (int i = 0; i < length; i++) {
            result[i] = arr[i];
        }

        result[length] = value;

        return result;
    }

    /**
     * Chèn phần tử vào vị trí chỉ định, vị trí phải >= 0 và <= arr.length
     * 
     * @param arr   - mảng nguồn
     * @param value - giá trị
     * @param index - vị trí (short)
     */
    int[] insert(int[] arr, int value, short index) {
        int length = arr.length;

        if (index < 0 || index > length) {
            System.err.printf("Index phải lớn hơn bằng 0 và nhỏ hơn bằng %d. Nhận vào: %d.\n", length, index);
            return arr;
        }

        int[] result = new int[length + 1];

        for (int i = 0, j = 0; i < length + 1; i++, j++) {
            if (i == index) {
                result[i] = value;
                j--;
                continue;
            }

            result[i] = arr[j];
        }

        return result;
    }

    /**
     * Xóa phần tử tại vị trí cuối cùng của mảng, trả về một mảng mới
     * 
     * @param arr - mảng nguồn
     */
    int[] remove(int[] arr) {
        int length = arr.length - 1;

        if (length < 0) {
            System.err.printf("Mảng nguồn không còn phần tử nào để mà xóa đâu :@");
            return arr;
        }

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    /**
     * Xóa phần tử tại vị trí chỉ định, vị trí phải >= 0 và <= arr.length, trả về
     * một mảng mới
     * 
     * @param arr   - mảng cần xóa
     * @param index - vị trí (short)
     */
    int[] remove(int[] arr, short index) {
        int length = arr.length - 1;

        if (length < 0) {
            System.err.printf("Mảng nguồn không còn phần tử nào để mà xóa đâu :@\n");
            return arr;
        }

        if (index < 0 || index > length) {
            System.err.printf("Index phải lớn hơn bằng 0 và nhỏ hơn bằng %d. Nhận vào: %d.\n", length, index);
            return arr;
        }

        int[] result = new int[length];

        for (int i = 0, j = 0; i < length; i++, j++) {
            if (j == index) {
                i--;
                continue;
            }

            result[i] = arr[j];
        }

        return result;
    }

    /**
     * Xóa phần tử theo giá trị chỉ định, trả về một mảng mới
     * 
     * @param arr   - mảng nguồn
     * @param value - giá trị cần xóa
     */
    int[] remove(int[] arr, int value) {
        int count = 0;

        for (int i : arr) {
            count += i == value ? 1 : 0;
        }

        if (count > 0) {
            int length = arr.length;
            int[] result = new int[length - count];

            for (int i = 0, j = 0; i < length; i++, j++) {
                if (arr[i] == value) {
                    j--;
                    continue;
                }

                result[j] = arr[i];
            }

            System.out.printf("Đã xóa %d phần tử khỏi mảng!\n", count);
            return result;
        }

        System.out.println("Không có phần tử nào khớp với giá trị chỉ định!");
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(Arrays.toString(new App().insert(arr, 4)));
        System.out.println(Arrays.toString(new App().insert(arr, 4, (short) 4)));
        System.out.println(Arrays.toString(new App().remove(arr)));
        System.out.println(Arrays.toString(new App().remove(arr, (short) 4)));
        System.out.println(Arrays.toString(new App().remove(arr, 3)));
    }
}
