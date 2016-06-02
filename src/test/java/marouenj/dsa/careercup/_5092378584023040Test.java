package marouenj.dsa.careercup;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class _5092378584023040Test {

    private final String SOLUTION = "solution";

    @DataProvider(name = SOLUTION)
    public Object[][] solution() {
        return new Object[][]{
                {
                        new String[]{"star", "dog", "car", "rats", "arc"},
                        new String[][]{
                                new String[]{"star", "rats"},
                                new String[]{"car", "arc"},
                                new String[]{"dog"},
                        },
                },
        };
    }

    @Test(dataProvider = SOLUTION)
    public void solution(String[] arr, String[][] expectedMatrix) {
        // test
        HashMap<String, Set<String>> actualMatrix = new _5092378584023040().solution(arr);

        // assert size
        Assert.assertEquals(actualMatrix.size(), expectedMatrix.length);

        String expected = reduce(expectedMatrix);
        String actual = reduce(actualMatrix.values());

        Assert.assertEquals(actual, expected);
    }

    private static String reduce(String[][] matrix) {
        // matrix to vector
        String[] vector = new String[matrix.length];
        int i = -1;
        for (String[] row : matrix) {
            i++;
            List<String> l = Arrays.asList(row);
            Collections.sort(l);
            vector[i] = l.toString();
        }

        // sort vector
        Arrays.sort(vector);

        // vector to scalar
        List<String> l = Arrays.asList(vector);
        return l.toString();
    }

    private static String reduce(Collection<Set<String>> matrix) {
        // matrix to vector
        String[] vector = new String[matrix.size()];
        int i = -1;
        for (Set<String> s : matrix) {
            i++;
            List<String> l = new ArrayList<>(s);
            Collections.sort(l);
            vector[i] = l.toString();
        }

        // sort vector
        Arrays.sort(vector);

        // vector to scalar
        List<String> l = Arrays.asList(vector);
        return l.toString();
    }
}
