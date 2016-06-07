package algo.reuse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import marouenj.dsa.reuse.Node2;
import marouenj.dsa.reuse.Node2WithCount;
import marouenj.dsa.reuse.Tree2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tree2Test {

    @Test
    public void TreeFromPreOrderInOrder_null() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Tree2.inOrder(null);
        Assert.assertEquals(byteArrayOutputStream.toString(), "");

        byteArrayOutputStream.reset();
        Tree2.preOrder(null);
        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void TreeFromPreOrderInOrder_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrder(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");

        byteArrayOutputStream.reset();
        Tree2.preOrder(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void TreeFromPreOrderInOrder_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrder(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, ");

        byteArrayOutputStream.reset();
        Tree2.preOrder(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), "2, 1, ");
    }

    @Test
    public void TreeFromPreOrderInOrder_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrder(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4, 5, 6, 7, ");

        byteArrayOutputStream.reset();
        Tree2.preOrder(root);
        Assert.assertEquals(byteArrayOutputStream.toString(), "5, 3, 2, 1, 4, 6, 7, ");
    }

    @Test
    public void isBalanced_null() {
        Node2<Integer> root = null;

        Assert.assertEquals(Tree2.isBalanced(root), true);
    }

    @Test
    public void isBalanced_1() throws Exception {
        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isBalanced(root), true);
    }

    @Test
    public void isBalanced_2() throws Exception {
        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isBalanced(root), true);
    }

    @Test
    public void isBalanced_3() throws Exception {
        Integer[] in = new Integer[]{2, 1};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isBalanced(root), true);
    }

    @Test
    public void isBalanced_4() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isBalanced(root), true);
    }

    @Test
    public void isBalanced_5() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7, 8, 9};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isBalanced(root), false);
    }

    @Test
    public void withBalancedDescendants_1() throws Exception {
        Character[] in = new Character[]{'D', 'C', 'E', 'B', 'F', 'H', 'G', 'A', 'J', 'L', 'M', 'K', 'N', 'I', 'O', 'P'};
        Character[] pre = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'};
        Node2<Character> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        int k = 3;

        Node2<Character> match = Tree2.withBalancedDescendants(root, k);

        Assert.assertNotEquals(match, null);
        Assert.assertEquals(match.getKey(), new Character('J'));
    }

    @Test
    public void preOrderRec_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = null;

        Tree2.preOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void preOrderRec_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void preOrderRec_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "2, 1, ");
    }

    @Test
    public void preOrderRec_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "5, 3, 2, 1, 4, 6, 7, ");
    }

    @Test
    public void inOrderRec_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = null;

        Tree2.inOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void inOrderRec_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void inOrderRec_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, ");
    }

    @Test
    public void inOrderRec_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4, 5, 6, 7, ");
    }

    @Test
    public void postOrderRec_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = null;

        Tree2.postOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void postOrderRec_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.postOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void postOrderRec_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.postOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, ");
    }

    @Test
    public void postOrderRec_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.postOrderRec(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 4, 3, 7, 6, 5, ");
    }

    @Test
    public void preOrder_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = null;

        Tree2.preOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void preOrder_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void preOrder_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "2, 1, ");
    }

    @Test
    public void preOrder_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "5, 3, 2, 1, 4, 6, 7, ");
    }

    @Test
    public void preOrderV2_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = null;

        Tree2.preOrderV2(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void preOrderV2_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrderV2(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void preOrderV2_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrderV2(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "2, 1, ");
    }

    @Test
    public void preOrderV2_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.preOrderV2(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "5, 3, 2, 1, 4, 6, 7, ");
    }

    @Test
    public void inOrder_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = null;

        Tree2.inOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void inOrder_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void inOrder_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, ");
    }

    @Test
    public void inOrder_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.inOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 3, 4, 5, 6, 7, ");
    }

    @Test
    public void postOrder_null() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Node2<Integer> root = null;

        Tree2.postOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "");
    }

    @Test
    public void postOrder_1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1};
        Integer[] pre = new Integer[]{1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.postOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, ");
    }

    @Test
    public void postOrder_2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.postOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, ");
    }

    @Test
    public void postOrder_3() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.postOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "1, 2, 4, 3, 7, 6, 5, ");
    }

    @Test
    public void postOrder_4() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        Integer[] pre = new Integer[]{9, 7, 6, 1, 3, 2, 5, 4, 8, 18, 11, 10, 17, 12, 16, 14, 13, 15};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.postOrder(root);

        Assert.assertEquals(byteArrayOutputStream.toString(), "2, 4, 5, 3, 1, 6, 8, 7, 10, 13, 15, 14, 16, 12, 17, 11, 18, 9, ");
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
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), true);
    }

    @Test
    public void isSymmetric_2() throws Exception {
        Integer[] in = new Integer[]{1, 2};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_3() throws Exception {
        Integer[] in = new Integer[]{2, 1};
        Integer[] pre = new Integer[]{2, 1};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_4() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_5() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] pre = new Integer[]{5, 3, 2, 1, 4, 6, 7, 8, 9};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_6() throws Exception {
        Integer[] in = new Integer[]{3, 2, 1, 4, 5};
        Integer[] pre = new Integer[]{1, 2, 3, 4, 5};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Assert.assertEquals(Tree2.isSymmetric(root), false);
    }

    @Test
    public void isSymmetric_7() throws Exception {
        Integer[] in = new Integer[]{3, 2, 1, 4, 5};
        Integer[] pre = new Integer[]{1, 2, 3, 4, 5};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
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
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(1);
        Node2<Integer> b = new Node2<>(3);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(2));
    }

    @Test
    public void lca_2() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(1);
        Node2<Integer> b = new Node2<>(11);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(9));
    }

    @Test
    public void lca_3() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(2);
        Node2<Integer> b = new Node2<>(4);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(2));
    }

    @Test
    public void lca_4() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
        Node2<Integer> a = new Node2<>(4);
        Node2<Integer> b = new Node2<>(7);

        Assert.assertEquals(Tree2.lca(root, a, b).getKey(), new Integer(6));
    }

    @Test
    public void lca_5() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
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
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

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
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);

        Tree2.border(root);
        Assert.assertEquals(baos.toString(), "1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, ");
    }

    @Test
    public void inOrderKthNode_1() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Integer[] pre = new Integer[]{9, 8, 2, 1, 3, 6, 5, 4, 7, 10, 12, 11, 13};
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
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
        Node2<Integer> root = Tree2.TreeFromPreOrderInOrder(in, pre);
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

    @Test
    public void sameInOrder_1() throws Exception {
        Integer[] in = new Integer[]{1, 2, 3};
        Integer[] pre1 = new Integer[]{1, 2, 3};
        Integer[] pre2 = new Integer[]{2, 1, 3};
        Node2<Integer> root1 = Tree2.TreeFromPreOrderInOrder(in, pre1);
        Node2<Integer> root2 = Tree2.TreeFromPreOrderInOrder(in, pre2);

        Assert.assertTrue(Tree2.sameInOrder(root1, root2));
    }
}
