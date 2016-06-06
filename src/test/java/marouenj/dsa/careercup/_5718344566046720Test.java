package marouenj.dsa.careercup;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _5718344566046720Test {

    private final String SOLUTION = "solution";

    @DataProvider(name = SOLUTION)
    public Object[][] solution() {
        return new Object[][]{
                {
                        new String[]{"star", "dog", "car", "rats", "arc"},
                        new String[]{"dgo"},
                },
        };
    }

    @Test(dataProvider = SOLUTION)
    public void solution(String[] arr, String[] nonAnagrams) {
        String[] newArr = new _5718344566046720().solution(arr);
        Assert.assertEquals(newArr, nonAnagrams);
    }
}
