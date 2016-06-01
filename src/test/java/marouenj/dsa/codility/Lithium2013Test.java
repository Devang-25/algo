package marouenj.dsa.codility;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lithium2013Test {

    @DataProvider(name = "solution")
    public Object[][] solution() {
        return new Object[][]{
                {
                        new int[][]{
                                {1, 2},
                                {2, 4},
                                {4, 3},
                                {2, 3},
                                {1, 3},
                        },
                        4,
                        4
                },
                {
                        new int[][]{
                                {1, 2},
                                {5, 1},
                        },
                        5,
                        1
                },
                {
                        new int[][]{
                                {2, 4},
                                {4, 6},
                                {5, 1},
                        },
                        6,
                        3
                },
                {
                        new int[][]{
                                {1, 2, 6},
                                {2, 3, 7},
                        },
                        7,
                        1
                },
        };
    }

    @Test(dataProvider = "solution")
    public void solution(int[][] arr, int p, int expected) {
        Assert.assertEquals(new Lithium2013().solution(arr, p), expected);
    }
}
