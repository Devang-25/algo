package marouenj.dsa.reuse;

import java.util.ArrayList;

public abstract class Arrays {

	/*
     * generic
	 */

    public static <A> void dump(A[] arr) {
        if (arr == null || arr.length == 0)
            return;

        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", " + arr[i]);
        }
        System.out.println();
    }

    public static <A extends Comparable<A>> void swap(A[] arr, int i, int j) {
        if (j < i) {
            Arrays.swap(arr, j, i);
            return;
        }

        if (arr == null || i < 0 || j >= arr.length || i == j) {
            return;
        }

        A tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <A extends Comparable<A>> int indexOf(A[] arr, A val) {
        return indexOf(arr, 0, arr.length - 1, val);
    }

    public static <A extends Comparable<A>> int indexOf(A[] arr, int lo, int hi, A val) {
        if (arr == null || lo > hi || lo < 0 || hi >= arr.length)
            return -1;
        while (lo <= hi) {
            if (arr[lo].compareTo(val) == 0)
                return lo;
            lo++;
        }
        return -1;
    }

    public static <A extends Comparable<A>> void shiftDown(A[] arr, int lo, int hi) {
        if (arr == null || lo >= hi || lo < 0 || hi >= arr.length)
            return;
        A tmp = arr[lo];
        for (int i = lo; i < hi; i++)
            arr[i] = arr[i + 1];
        arr[hi] = tmp;
    }

    public static <A extends Comparable<A>> void shiftUp(A[] arr, int lo, int hi) {
        if (arr == null || lo >= hi || lo < 0 || hi >= arr.length)
            return;
        A tmp = arr[hi];
        for (int i = hi; i > lo; i--)
            arr[i] = arr[i - 1];
        arr[lo] = tmp;
    }

	/*
	 * integer-specific
	 */

    public static Integer[] clone(Integer[] arr) {
        Integer[] copy = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            copy[i] = arr[i];
        return copy;
    }

    /*
     * find the intersection between two sorted arrays
     * loop over the array with less entries
     * for each entry do a bin search on the second array
     */
    public static <A extends Comparable<A>> ArrayList<A> duplicatesBetweenTwoSorted(A[] arr_short, A[] arr_long) {
        ArrayList<A> dup = new ArrayList<>();
        for (int i = 0; i < arr_short.length; i++) {
            int idx = Search.bin(arr_long, arr_short[i]);
            if (idx != -1)
                dup.add(arr_short[i]);
        }
        return dup;
    }
}
