package algo.reuse;

import marouenj.dsa.reuse.Search;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest {

    @Test
    public void bin_null() {
        Integer[] arr = null;
        Integer a = 0;

        Assert.assertEquals(Search.bin(arr, a), -1);
    }

    @Test
    public void bin_null_1() {
        Integer[] arr = new Integer[]{1, 2, 3};
        Integer a = null;

        Assert.assertEquals(Search.bin(arr, a), -1);
    }

    @Test
    public void binWithRanges_null() {
        Integer[] arr = null;
        int lo = 0;
        int hi = 5;
        Integer a = 0;

        Assert.assertEquals(Search.bin(arr, lo, hi, a), -1);
    }

    @Test
    public void binWithRanges_null_1() {
        Integer[] arr = new Integer[]{1, 2, 3};
        int lo = 0;
        int hi = 5;
        Integer a = null;

        Assert.assertEquals(Search.bin(arr, lo, hi, a), -1);
    }

    @Test
    public void binWithRanges_1() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int lo = 0;
        int hi = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            Integer a = arr[i];
            Assert.assertEquals(Search.bin(arr, lo, hi, a), i);
        }
    }

    @Test
    public void binWithRanges_2() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int lo = 3;
        int hi = arr.length - 3;

        for (int i = 0; i < lo; i++) {
            Integer a = arr[i];
            Assert.assertEquals(Search.bin(arr, lo, hi, a), -1);
        }

        for (int i = lo; i <= hi; i++) {
            Integer a = arr[i];
            Assert.assertEquals(Search.bin(arr, lo, hi, a), i);
        }

        for (int i = hi + 1; i < arr.length; i++) {
            Integer a = arr[i];
            Assert.assertEquals(Search.bin(arr, lo, hi, a), -1);
        }
    }

    @Test
    public void bin1_1() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5, 11, 12, 13, 14, 15, 16, 22};
        Integer[] arr2 = new Integer[]{6, 7, 8, 9, 10, 17, 18, 19, 20, 21};

        int[] expected = new int[]{0, 0, 0, 0, 0, 5, 5, 5, 5, 5, 5, -1};

        for (int i = 0; i < arr1.length; i++) {
            Assert.assertEquals(Search.bin1(arr2, arr1[i]), expected[i]);
        }
    }

    @Test
    public void kthSorted_1() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5};
        Integer[] arr2 = new Integer[]{6, 7, 8, 9, 10};

        Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(Search.kthSorted(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1, i + 1), expected[i]);
        }
    }

    @Test
    public void kthSorted_2() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5, 11, 12, 13, 14, 15, 16};
        Integer[] arr2 = new Integer[]{6, 7, 8, 9, 10, 17, 18, 19, 20, 21};

        Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals(Search.kthSorted(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1, i + 1), expected[i]);
        }
    }
}
