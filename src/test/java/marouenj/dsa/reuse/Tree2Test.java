package marouenj.dsa.reuse;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Tree2Test {

    private final String TREE_FROM_PRE_ORDER_IN_ORDER = "treeFromPreOrderInOrder";

    @DataProvider(name = TREE_FROM_PRE_ORDER_IN_ORDER)
    public Object[][] treeFromPreOrderInOrder() throws Exception {
        Integer[][] in = new Integer[][]{
                new Integer[]{1},
                new Integer[]{1, 2},
                new Integer[]{5, 3, 2, 1, 4, 6, 7},
        };

        Integer[][] pre = new Integer[][]{
                new Integer[]{1},
                new Integer[]{2, 1},
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
        };

        String[] expectedPre = new String[]{
                "1, ",
                "1, 2, ",
                "5, 3, 2, 1, 4, 6, 7, ",
        };

        String[] expectedIn = new String[]{
                "1, ",
                "2, 1, ",
                "1, 2, 3, 4, 5, 6, 7, ",
        };

        int offset = 0; // add special cases at the beginning
        Object[][] data = new Object[in.length + 1][];
        data[offset++] = new Object[]{null, "", ""}; // special case where root is null

        for (int i = 0; i < in.length; i++) {
            Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in[i], pre[i]);
            data[offset + i] = new Object[]{root, expectedPre[i], expectedIn[i]};
        }

        return data;
    }

    @Test(dataProvider = TREE_FROM_PRE_ORDER_IN_ORDER)
    public void treeFromPreOrderInOrder(Node2<Integer> root, String expectedPre, String expectedIn) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Tree2.preOrderV2(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), expectedPre);

        byteArrayOutputStream.reset();
        Tree2.inOrder(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), expectedIn);
    }

    private final String IS_BALANCED = "isBalanced";

    @DataProvider(name = IS_BALANCED)
    public Object[][] isBalanced() throws Exception {
        Integer[][] in = new Integer[][]{
                new Integer[]{1},
                new Integer[]{1, 2},
                new Integer[]{2, 1},
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
        };

        Integer[][] pre = new Integer[][]{
                new Integer[]{1},
                new Integer[]{2, 1},
                new Integer[]{2, 1},
                new Integer[]{5, 3, 2, 1, 4, 6, 7},
                new Integer[]{5, 3, 2, 1, 4, 6, 7, 8, 9}
        };

        boolean[] expected = new boolean[]{
                true,
                true,
                true,
                true,
                false,
        };

        int offset = 0; // add special cases at the beginning
        Object[][] data = new Object[in.length + 1][];
        data[offset++] = new Object[]{null, true}; // special case where root is null

        for (int i = 0; i < in.length; i++) {
            Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in[i], pre[i]);
            data[offset + i] = new Object[]{root, expected[i]};
        }

        return data;
    }

    @Test(dataProvider = IS_BALANCED)
    public void isBalanced(Node2<Integer> root, boolean expected) {
        Assert.assertEquals(Tree2.isBalanced(root), expected);
    }

    private final String PRE_ORDER = "preOrder";

    @DataProvider(name = PRE_ORDER)
    public Object[][] preOrder() throws Exception {
        Integer[][] pre = new Integer[][]{
                new Integer[]{1},
                new Integer[]{1, 2},
                new Integer[]{2, 1},
                new Integer[]{5, 3, 2, 1, 4, 6, 7},
        };

        Integer[][] in = new Integer[][]{
                new Integer[]{1},
                new Integer[]{2, 1},
                new Integer[]{1, 2},
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
        };

        String[] expected = new String[]{
                "1, ",
                "1, 2, ",
                "2, 1, ",
                "5, 3, 2, 1, 4, 6, 7, ",
        };

        int offset = 0; // add special cases at the beginning
        Object[][] data = new Object[in.length + 1][];
        data[offset++] = new Object[]{null, ""}; // special case where root is null

        for (int i = 0; i < in.length; i++) {
            Node2<Integer> root = Tree2.treeFromPreOrderInOrder(pre[i], in[i]);
            data[offset + i] = new Object[]{root, expected[i]};
        }

        return data;
    }

    @Test(dataProvider = PRE_ORDER)
    public void preOrder(Node2<Integer> root, String expected) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Tree2.preOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), expected);
    }

    @Test(dataProvider = PRE_ORDER)
    public void preOrderV2(Node2<Integer> root, String expected) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Tree2.preOrderV2(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), expected);
    }

    @Test(dataProvider = PRE_ORDER)
    public void preOrderV3(Node2<Integer> root, String expected) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Tree2.preOrderV3(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), expected);
    }

    private final String IN_ORDER = "inOrder";

    @DataProvider(name = IN_ORDER)
    public Object[][] inOrder() throws Exception {
        Integer[][] pre = new Integer[][]{
                new Integer[]{1},
                new Integer[]{1, 2},
                new Integer[]{2, 1},
                new Integer[]{5, 3, 2, 1, 4, 6, 7},
        };

        Integer[][] in = new Integer[][]{
                new Integer[]{1},
                new Integer[]{2, 1},
                new Integer[]{1, 2},
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
        };

        String[] expected = new String[]{
                "1, ",
                "2, 1, ",
                "1, 2, ",
                "1, 2, 3, 4, 5, 6, 7, ",
        };

        int offset = 0; // add special cases at the beginning
        Object[][] data = new Object[in.length + 1][];
        data[offset++] = new Object[]{null, ""}; // special case where root is null

        for (int i = 0; i < in.length; i++) {
            Node2<Integer> root = Tree2.treeFromPreOrderInOrder(pre[i], in[i]);
            data[offset + i] = new Object[]{root, expected[i]};
        }

        return data;
    }

    @Test(dataProvider = IN_ORDER)
    public void inOrder(Node2<Integer> root, String expected) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Tree2.inOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), expected);
    }

    private final String POST_ORDER = "postOrder";

    @DataProvider(name = POST_ORDER)
    public Object[][] postOrder() throws Exception {
        Integer[][] pre = new Integer[][]{
                new Integer[]{1},
                new Integer[]{2, 1},
                new Integer[]{5, 3, 2, 1, 4, 6, 7},
                new Integer[]{9, 7, 6, 1, 3, 2, 5, 4, 8, 18, 11, 10, 17, 12, 16, 14, 13, 15},
        };

        Integer[][] in = new Integer[][]{
                new Integer[]{1},
                new Integer[]{1, 2},
                new Integer[]{1, 2, 3, 4, 5, 6, 7},
                new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18},
        };

        String[] expected = new String[]{
                "1, ",
                "1, 2, ",
                "1, 2, 4, 3, 7, 6, 5, ",
                "2, 4, 5, 3, 1, 6, 8, 7, 10, 13, 15, 14, 16, 12, 17, 11, 18, 9, ",
        };

        int offset = 0; // add special cases at the beginning
        Object[][] data = new Object[in.length + 1][];
        data[offset++] = new Object[]{null, ""}; // special case where root is null

        for (int i = 0; i < in.length; i++) {
            Node2<Integer> root = Tree2.treeFromPreOrderInOrder(pre[i], in[i]);
            data[offset + i] = new Object[]{root, expected[i]};
        }

        return data;
    }

    @Test(dataProvider = POST_ORDER)
    public void postOrder(Node2<Integer> root, String expected) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Tree2.postOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), expected);
    }

    private final String SAME_IN_ORDER = "sameInOrder";

    @DataProvider(name = SAME_IN_ORDER)
    public Object[][] sameInOrder() {
        return new Object[][]{
                {
                        new Integer[]{1, 2, 3},
                        new Integer[]{1, 2, 3},
                        new Integer[]{2, 1, 3}
                },
        };
    }

    @Test(dataProvider = SAME_IN_ORDER)
    public void sameInOrder(Integer[] in, Integer[] pre1, Integer[] pre2) throws Exception {
        Node2<Integer> root1 = Tree2.treeFromPreOrderInOrder(pre1, in);
        Node2<Integer> root2 = Tree2.treeFromPreOrderInOrder(pre2, in);

        Assert.assertTrue(Tree2.sameInOrder(root1, root2));
    }

    @Test
    public void isSymmetric_null() {
        Node2<Integer> root = null;

        Assert.assertEquals(Tree2.isSymmetric(root), true);
    }

    @Test
    public void isSymmetric_1() throws Exception {
        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), true);
    }

    @Test
    public void isSymmetric_2() throws Exception {
        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_3() throws Exception {
        Integer[] in = new Integer[]{2, 1};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_4() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_5() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7, 8, 9};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_6() throws Exception {
        Integer[] in = new Integer[]{3, 2, 1, 4, 5};
        Integer[] pre = new Integer[]{1, 2, 3, 4, 5};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_7() throws Exception {
        Integer[] in = new Integer[]{3, 2, 1, 4, 5};
        Integer[] pre = new Integer[]{1, 2, 3, 4, 5};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        root.getRight().setKey(2);
        root.getRight().getRight().setKey(3);

        Assert.assertEquals(Tree2.isSymmetric(root), true);
    }

    @Test
    public void lca_null() {
        Assert.assertEquals(Tree2.lca(null, new Node2<Integer>(1), new Node2<Integer>(2)), null);
    }

    @Test
    public void lca_1() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(1);
        Node2<Integer> b = new Node2<>(3);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(2));
    }

    @Test
    public void lca_2() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(1);
        Node2<Integer> b = new Node2<>(11);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(9));
    }

    @Test
    public void lca_3() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(2);
        Node2<Integer> b = new Node2<>(4);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(2));
    }

    @Test
    public void lca_4() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(4);
        Node2<Integer> b = new Node2<>(7);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(6));
    }

    @Test
    public void lca_5() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(9);
        Node2<Integer> b = new Node2<>(11);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(9));
    }

    @Test
    public void border_null() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Tree2.border(null);
        Assert.assertEquals(baos.toString(), "");
    }

    @Test
    public void border_1() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Tree2.border(root);
        Assert.assertEquals(baos.toString(), "9, 8, 2, 1, 4, 7, 11, 13, 12, 10, ");
    }

    @Test
    public void border_2() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        Integer[] in = new Integer[]{4, 3, 5, 2, 6, 100, 7, 1, 8, 200, 9, 13, 10, 12, 11};
        Integer[] pre = new Integer[]{1, 2, 3, 4, 5, 100, 6, 7, 13, 200, 8, 9, 12, 10, 11};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);

        Tree2.border(root);
        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, ");
    }

    @Test
    public void inOrderKthNode_1() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        Node2WithCount<Integer> withCount = Tree2.withCount(root);

        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 1).getKey(), new Integer(1));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 2).getKey(), new Integer(2));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 3).getKey(), new Integer(3));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 4).getKey(), new Integer(4));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 5).getKey(), new Integer(5));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 6).getKey(), new Integer(6));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 7).getKey(), new Integer(7));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 8).getKey(), new Integer(8));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 9).getKey(), new Integer(9));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 10).getKey(), new Integer(10));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 11).getKey(), new Integer(11));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 12).getKey(), new Integer(12));
        Assert.assertEquals(Tree2.inOrderKthNodeRec(withCount, 13).getKey(), new Integer(13));
    }

    @Test
    public void inOrderKthNode_2() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.treeFromPreOrderInOrder(in, pre);
        Node2WithCount<Integer> withCount = Tree2.withCount(root);

        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 1).getKey(), new Integer(1));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 2).getKey(), new Integer(2));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 3).getKey(), new Integer(3));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 4).getKey(), new Integer(4));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 5).getKey(), new Integer(5));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 6).getKey(), new Integer(6));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 7).getKey(), new Integer(7));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 8).getKey(), new Integer(8));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 9).getKey(), new Integer(9));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 10).getKey(), new Integer(10));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 11).getKey(), new Integer(11));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 12).getKey(), new Integer(12));
        Assert.assertEquals(Tree2.inOrderKthNode(withCount, 13).getKey(), new Integer(13));
    }
}
