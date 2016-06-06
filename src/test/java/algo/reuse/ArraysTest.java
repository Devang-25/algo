package algo.reuse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.Assert;
import org.testng.annotations.Test;

import algo.reuse.Arrays;

public class ArraysTest {

    private final static Integer[] ARR_NULL;
    private final static Integer[] ARR_EMPTY;

    static {
        ARR_NULL = null;
        ARR_EMPTY = new Integer[]{};
    }

    @Test
    public void dump_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        Arrays.dump(ARR_NULL);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void dump_empty() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        Arrays.dump(ARR_EMPTY);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void dump() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Arrays.dump(arr);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4\n");
    }

    @Test
    public void swap_null() {
        Arrays.swap(ARR_NULL, 0, 1);
        Assert.assertEquals(ARR_NULL, null);
    }

    @Test
    public void swap_empty() {
        Arrays.swap(ARR_EMPTY, 0, 1);
        Assert.assertEquals(ARR_EMPTY, new Integer[]{});
    }

    @Test
    public void swap_outOfBoundToTheLeft() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Arrays.swap(arr, -1, 1);
        Assert.assertEquals(arr, new Integer[]{1, 2, 3, 4});
    }

    @Test
    public void swap_outOfBoundToTheRight() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Arrays.swap(arr, 0, 4);
        Assert.assertEquals(arr, new Integer[]{1, 2, 3, 4});
    }

    @Test
    public void swap_equalIndexes() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Arrays.swap(arr, 0, 0);
        Assert.assertEquals(arr, new Integer[]{1, 2, 3, 4});
    }

    @Test
    public void swap() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Arrays.swap(arr, 0, 3);
        Assert.assertEquals(arr, new Integer[]{4, 2, 3, 1});
    }

    @Test
    public void swap2() {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        Arrays.swap(arr, 0, 3);
        Integer[] arr2 = new Integer[]{1, 2, 3, 4};
        Arrays.swap(arr, 3, 0);
        Assert.assertEquals(arr, arr2);
    }
}
