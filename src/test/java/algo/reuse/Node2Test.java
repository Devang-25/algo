package algo.reuse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;

import marouenj.dsa.reuse.Node2;
import marouenj.dsa.reuse.Tree2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Node2Test {

    @Test
    public void inOrderIterator_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Iterator<Integer> itr = root.inOrderIterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.print(next + ", ");
        }

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void inOrderIterator_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Iterator<Integer> itr = root.inOrderIterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.print(next + ", ");
        }

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, ");
    }

    @Test
    public void inOrderIterator_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Iterator<Integer> itr = root.inOrderIterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.print(next + ", ");
        }

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4, 5, 6, 7, ");
    }
}
