package algo.careercup.amazon;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import marouenj.dsa.careercup.amazon.Arrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraysTest {

    @Test
    public void _2() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 5, 5, 6, 7, 7};
//		Array._2(arr);
        Arrays._2_2(arr);

        Assert.assertEquals(byteArrayOutputStream.toString(), "5 is repeated 3 times, 7 is repeated 2 times, 1 is repeated 1 times, 2 is repeated 1 times, 3 is repeated 1 times, 4 is repeated 1 times, 6 is repeated 1 times, \n");
    }
}
