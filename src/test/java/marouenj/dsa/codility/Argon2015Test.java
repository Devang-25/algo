package marouenj.dsa.codility;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Argon2015Test {

    @DataProvider(name = "solution")
    public Object[][] solution() {
        return new Object[][]{
                {new int[]{1, 1, 0, 1, 0, 0, 1, 1}, 7},
        };
    }

    @Test(dataProvider = "solution")
    public void solution(int[] arr, int expected) {
        int actual = new Argon2015().solution(arr);
        Assert.assertEquals(actual, expected);
    }
}
