package marouenj.dsa.codility;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Aluminium2014Test {

    @DataProvider(name = "solution")
    public Object[][] solution() {
        return new Object[][]{
                {new int[]{3, 2, -6, 3, 1}, 9},
        };
    }

    @Test(dataProvider = "solution")
    public void solution(int[] arr, int expected) {
        int actual = new Aluminium2014().solution(arr);
        Assert.assertEquals(actual, expected);
    }
}
