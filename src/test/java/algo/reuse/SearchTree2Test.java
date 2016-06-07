package algo.reuse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import marouenj.dsa.reuse.LinkedList;
import marouenj.dsa.reuse.Node2;
import marouenj.dsa.reuse.SearchTree2;
import marouenj.dsa.reuse.Tree2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTree2Test {

    @Test
    public void isSearchTree2_1() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertTrue(SearchTree2.isSearchTree2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void isSearchTree2_2() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 175, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 175, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertFalse(SearchTree2.isSearchTree2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void min_null() {
        Assert.assertNull(SearchTree2.min(null));
    }

    @Test
    public void min_1() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(SearchTree2.min(root).getKey(), (Integer) 23);
    }

    @Test
    public void max_null() {
        Assert.assertNull(SearchTree2.max(null));
    }

    @Test
    public void max_1() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(SearchTree2.max(root).getKey(), (Integer) 175);
    }

    @Test
    public void get() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Integer key = null;

        key = 50;
        Assert.assertEquals(SearchTree2.get(root, key).getKey(), key);

        key = 100;
        Assert.assertEquals(SearchTree2.get(root, key).getKey(), key);

        key = 175;
        Assert.assertEquals(SearchTree2.get(root, key).getKey(), key);

        key = 200;
        Assert.assertEquals(SearchTree2.get(root, key), null);
    }

    @Test
    public void getMinFirst() throws Exception {
        Integer[] in = new Integer[]{21, 20, 29, 10, 51, 50, 119, 5, 152, 151, 150, 120, 200, 201, 202};
        Integer[] pre = new Integer[]{5, 10, 20, 21, 29, 50, 51, 119, 120, 150, 151, 152, 200, 201, 202};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Integer key;

        for (int i = 0; i < pre.length; i++) {
            key = pre[i];
            Assert.assertEquals(SearchTree2.getMinFirst(root, key).getKey(), key);
        }

        Integer[] non = new Integer[]{1, 7, 15, 25, 45, 100, 115, 135, 195};
        for (int i = 0; i < non.length; i++) {
            key = non[i];
            Assert.assertNull(SearchTree2.getMinFirst(root, key));
        }
    }

    @Test
    public void succ() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Integer key = null;

        key = 23;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 24);

        key = 24;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 25);

        key = 25;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 26);

        key = 26;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 27);

        key = 27;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 50);

        key = 50;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 75);

        key = 75;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 100);

        key = 100;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 125);

        key = 125;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 150);

        key = 150;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 175);

        key = 175;
        Assert.assertNull(SearchTree2.succ(root, key));
    }

    @Test
    public void larger() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Integer key;

        key = 1;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 23);

        key = 10;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 23);

        key = 20;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 23);

        key = 22;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 23);

        key = 23;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 24);

        key = 24;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 25);

        key = 25;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 26);

        key = 26;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 27);

        key = 27;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 50);

        key = 28;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 50);

        key = 101;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 125);

        key = 174;
        Assert.assertEquals(SearchTree2.larger(root, key).getKey(), (Integer) 175);

        key = 175;
        Assert.assertNull(SearchTree2.larger(root, key));
    }

    @Test
    public void kLargest() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        List<Integer> kLargest;

        kLargest = SearchTree2.kLargest(root, 1);
        Assert.assertEquals(kLargest.toString(), "[175]");

        kLargest = SearchTree2.kLargest(root, 2);
        Assert.assertEquals(kLargest.toString(), "[150, 175]");

        kLargest = SearchTree2.kLargest(root, 3);
        Assert.assertEquals(kLargest.toString(), "[125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 4);
        Assert.assertEquals(kLargest.toString(), "[100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 5);
        Assert.assertEquals(kLargest.toString(), "[75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 6);
        Assert.assertEquals(kLargest.toString(), "[50, 75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 7);
        Assert.assertEquals(kLargest.toString(), "[27, 50, 75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 8);
        Assert.assertEquals(kLargest.toString(), "[26, 27, 50, 75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 9);
        Assert.assertEquals(kLargest.toString(), "[25, 26, 27, 50, 75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 10);
        Assert.assertEquals(kLargest.toString(), "[24, 25, 26, 27, 50, 75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 11);
        Assert.assertEquals(kLargest.toString(), "[23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 12);
        Assert.assertEquals(kLargest.toString(), "[23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175]");

        kLargest = SearchTree2.kLargest(root, 13);
        Assert.assertEquals(kLargest.toString(), "[23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175]");
    }

    @Test
    public void insert() throws Exception {
        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Integer key = null;

        key = 28;
        SearchTree2.insert(root, key);
        Assert.assertEquals(SearchTree2.get(root, key).getKey(), key);
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 50);

        key = 27;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 28);

        key = 200;
        SearchTree2.insert(root, key);
        Assert.assertEquals(SearchTree2.get(root, key).getKey(), key);
        Assert.assertNull(SearchTree2.succ(root, key));

        key = 175;
        Assert.assertEquals(SearchTree2.succ(root, key).getKey(), (Integer) 200);
    }

    @Test
    public void toLinkedList() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] in = new Integer[]{23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175};
        Integer[] pre = new Integer[]{100, 50, 25, 24, 23, 26, 27, 75, 150, 125, 175};

        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Node2<Integer> head = SearchTree2.toLinkedList(root);
        LinkedList.dump(head);

        Assert.assertEquals(baos.toString(), "23, 24, 25, 26, 27, 50, 75, 100, 125, 150, 175\n");
    }
}
