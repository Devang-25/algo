package marouenj.dsa.reuse;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

@Test(ignoreMissingDependencies = true)
public class Node2Test {

    private final String IN_ORDER_ITERATOR = "inOrderIterator";

    @DataProvider(name = IN_ORDER_ITERATOR)
    public Object[][] inOrderIterator() {
        return new Object[][]{
                {
                        new Integer[]{1},
                        new Integer[]{1},
                        "1, ",
                },
                {
                        new Integer[]{1, 2},
                        new Integer[]{2, 1},
                        "1, 2, ",
                },
                {
                        new Integer[]{1, 2, 3, 4, 5, 6, 7},
                        new Integer[]{5, 3, 2, 1, 4, 6, 7},
                        "1, 2, 3, 4, 5, 6, 7, ",
                },
        };
    }

    @Test(dataProvider = IN_ORDER_ITERATOR)
    public void inOrderIterator_1(Integer[] in, Integer[] pre, String expected) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Iterator<Integer> itr = root.inOrderIterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.print(next + ", ");
        }

        Assert.assertEquals(byteArrayOutputStream.toString(), expected);
    }
}
