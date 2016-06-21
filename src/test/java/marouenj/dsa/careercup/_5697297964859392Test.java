package marouenj.dsa.careercup;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class _5697297964859392Test {

    private final String SOLUTION = "solution";

    @DataProvider(name = SOLUTION)
    public Object[][] solution() {
        return new Object[][]{
                {
                        new int[]{1, 2, 3, 4, 5, 5, 5, 6, 7, 7},
                        "5 is repeated 3 times, 7 is repeated 2 times, 1 is repeated 1 times, 2 is repeated 1 times, 3 is repeated 1 times, 4 is repeated 1 times, 6 is repeated 1 times, ",
                }
        };
    }

    @Test(dataProvider = SOLUTION)
    public void solution(int[] arr, String expected) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        new _5697297964859392().solution(arr);

        Assert.assertEquals(byteArrayOutputStream.toString(), expected);
    }
}
