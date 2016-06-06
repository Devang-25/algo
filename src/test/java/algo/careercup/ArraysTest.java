package algo.careercup;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraysTest {

    @Test
    public void _1() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] A = new Integer[]{2, 1, 3};
        Integer[] B = new Integer[]{6, 5, 4};
        Integer[] C = new Integer[]{7, 9, 8};

        Assert.assertFalse(Arrays._1(A, B, C, 1));
        Assert.assertFalse(Arrays._1(A, B, C, 2));
        Assert.assertFalse(Arrays._1(A, B, C, 3));
        Assert.assertFalse(Arrays._1(A, B, C, 4));
        Assert.assertFalse(Arrays._1(A, B, C, 5));
        Assert.assertFalse(Arrays._1(A, B, C, 6));
        Assert.assertFalse(Arrays._1(A, B, C, 7));
        Assert.assertFalse(Arrays._1(A, B, C, 8));
        Assert.assertFalse(Arrays._1(A, B, C, 9));
        Assert.assertFalse(Arrays._1(A, B, C, 10));
        Assert.assertFalse(Arrays._1(A, B, C, 11));
        Assert.assertTrue(Arrays._1(A, B, C, 12));
        Assert.assertTrue(Arrays._1(A, B, C, 13));
        Assert.assertTrue(Arrays._1(A, B, C, 14));
        Assert.assertTrue(Arrays._1(A, B, C, 15));
        Assert.assertTrue(Arrays._1(A, B, C, 16));
        Assert.assertTrue(Arrays._1(A, B, C, 17));
        Assert.assertTrue(Arrays._1(A, B, C, 18));
        Assert.assertFalse(Arrays._1(A, B, C, 19));
    }
}
