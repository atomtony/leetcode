package day1.array;

import java.util.Arrays;

public class MergeTwoArray {


    public static int[] merge(int[] a, int[] b) {

        if (a == null || a.length == 0) {
            return b;
        }

        if (b == null || b.length == 0) {
            return a;
        }

        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else if (a[i] == b[j]) {
                c[k++] = a[i++];
                c[k++] = b[j++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < a.length) {
            c[k++] = a[i++];
        }

        while (j < b.length) {
            c[k++] = b[j++];
        }

        return c;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5};
        int[] b = new int[]{2, 3, 4, 6};
        int[] c = merge(a, b);
        System.out.println(Arrays.toString(c));
    }


}
