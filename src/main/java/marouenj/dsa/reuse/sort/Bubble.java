package marouenj.dsa.reuse.sort;

import marouenj.dsa.reuse.Arrays;

public class Bubble {

    public static <A extends Comparable<A>> void sort(A[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        boolean once = true;
        int hi = arr.length;

        while (once) {
            once = false;
            for (int i = 1; i < hi; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    once = true;
                    Arrays.swap(arr, i - 1, i);
                }
            }
            hi--;
        }
    }
}
