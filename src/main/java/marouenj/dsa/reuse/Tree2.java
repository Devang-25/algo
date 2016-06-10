package marouenj.dsa.reuse;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class Tree2 {

    /**
     * Deserialize a tree from pre-order and in-order traversals
     *
     * @param pre Serialized pre-order traversal
     * @param in  Serialized in-order traversal
     * @param <A> Key type
     * @return Root ${Node2}
     * @throws Exception Invalid input
     */
    public static <A extends Comparable<A>> Node2<A> treeFromPreOrderInOrder(A[] pre, A[] in) throws Exception {
        if (pre == null || in == null || pre.length != in.length || pre.length == 0) {
            throw new Exception("Invalid input");
        }

        return treeFromPreOrderInOrderHelper(pre, 0, in, 0, in.length - 1);
    }

    private static <A extends Comparable<A>> Node2<A> treeFromPreOrderInOrderHelper(A[] pre, int pre_lo, A[] in, int in_lo, int in_hi) throws Exception {
        if (in_lo > in_hi) {
            return null;
        }

        Node2<A> n = new Node2<>(pre[pre_lo]);

        int idx = Arrays.indexOf(in, in_lo, in_hi, pre[pre_lo]);
        if (idx == -1) {
            throw new Exception("Key not found");
        }

        n.setLeft(treeFromPreOrderInOrderHelper(pre, pre_lo + 1, in, in_lo, idx - 1));
        n.setRight(treeFromPreOrderInOrderHelper(pre, pre_lo + (idx - in_lo) + 1, in, idx + 1, in_hi));

        return n;
    }

    /**
     * Check if a binary tree is balanced
     *
     * @param n   Root ${Node2} of the tree
     * @param <A> Key type
     * @return True if the tree is balanced
     */
    public static <A extends Comparable<A>> boolean isBalanced(Node2<A> n) {
        return isBalancedHelper(n) != -1;
    }

    private static <A extends Comparable<A>> int isBalancedHelper(Node2<A> n) {
        // base case
        if (n == null) {
            return 0;
        }

        int l = isBalancedHelper(n.getLeft());
        if (l == -1) {
            return -1;
        }

        int r = isBalancedHelper(n.getRight());
        if (r == -1) {
            return -1;
        }

        int diff = Math.abs(l - r);
        if (diff > 1) {
            return -1;
        }

        return diff + 1;
    }

	/*
     * traversal
	 */

    public static <A extends Comparable<A>> void preOrderRec(Node2<A> n) {
        // base case
        if (n == null) {
            return;
        }

        System.out.print(n.getKey() + ", ");
        preOrderRec(n.getLeft());
        preOrderRec(n.getRight());
    }

    public static <A extends Comparable<A>> void inOrderRec(Node2<A> n) {
        // base case
        if (n == null) {
            return;
        }

        inOrderRec(n.getLeft());
        System.out.print(n.getKey() + ", ");
        inOrderRec(n.getRight());
    }

    public static <A extends Comparable<A>> void postOrderRec(Node2<A> n) {
        // base case
        if (n == null) {
            return;
        }

        postOrderRec(n.getLeft());
        postOrderRec(n.getRight());
        System.out.print(n.getKey() + ", ");
    }

    public static <A extends Comparable<A>> void preOrder(Node2<A> n) {
        Stack<Node2<A>> stack = new Stack<>();
        stack.push(n);

        while (!stack.isEmpty()) {
            Node2<A> node = stack.pop();

            if (node == null) {
                continue;
            }

            System.out.print(node.getKey() + ", ");

            stack.push(node.getRight());
            stack.push(node.getLeft());
        }
    }

    public static <A extends Comparable<A>> void preOrderV2(Node2<A> n) {
        if (n == null) { // make sure null values are not pushed
            return;
        }

        Stack<Node2<A>> stack = new Stack<>();
        stack.push(n);

        while (!stack.isEmpty()) {
            Node2<A> node = stack.pop();
            System.out.print(node.getKey() + ", ");
            if (node.getRight() != null) { // make sure null values are not pushed
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) { // make sure null values are not pushed
                stack.push(node.getLeft());
            }
        }
    }

    public static <A extends Comparable<A>> void preOrderV3(Node2<A> curr) {
        Stack<Node2<A>> stack = new Stack<>();

        while (curr != null || !stack.empty()) {
            if (curr == null) {
                curr = stack.pop();
                continue;
            }

            System.out.print(curr.getKey() + ", ");
            stack.push(curr.getRight());
            curr = curr.getLeft();
        }
    }

    public static <A extends Comparable<A>> void inOrder(Node2<A> n) {
        Node2<A> curr = n;
        Stack<Node2<A>> stack = new Stack<>();

        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.getLeft();
            } else {
                curr = stack.pop();
                System.out.print(curr.getKey() + ", ");
                curr = curr.getRight();
            }
        }
    }

    public static <A extends Comparable<A>> void postOrder(Node2<A> n) {
        Node2<A> prev = null;
        Node2<A> curr = n;
        Stack<Node2<A>> stack = new Stack<>();

        boolean pushing = true;
        while (curr != null || !stack.isEmpty()) {
            if (curr == null) {
                prev = curr;
                curr = stack.pop();
                pushing = false;
                continue;
            }

            if (pushing) {
                stack.push(curr);
                prev = curr;
                if (curr.getLeft() != null) {
                    curr = curr.getLeft();
                } else {
                    curr = curr.getRight();
                }
            } else {
                if (curr.getRight() != prev) {
                    stack.push(curr);
                    prev = curr;
                    curr = curr.getRight();
                    pushing = true;
                } else {
                    System.out.print(curr.getKey() + ", ");
                    prev = curr;
                    curr = (stack.empty() ? null : stack.pop());
                }
            }
        }
    }

	/*
     * traversal signature
	 */

    public static <A extends Comparable<A>> boolean sameInOrder(Node2<A> one, Node2<A> two) {
        if (one == null && two == null) { // both are null
            return true;
        }

        if (one != null && two != null) { // both are not null
            Iterator<A> itr1 = one.inOrderIterator();
            Iterator<A> itr2 = two.inOrderIterator();

            while (itr1.hasNext() && itr2.hasNext()) {
                if (itr1.next().compareTo(itr2.next()) != 0) {
                    return false;
                }
            }

            if (itr1.hasNext() || itr2.hasNext()) { // exactly one still has elements to process
                return false;
            }

            // both have no more elements to process
            return true;
        }

        // exactly one is null
        return false;
    }

	/*
     * symmetry
	 */

    public static <A extends Comparable<A>> boolean isSymmetric(Node2<A> n) {
        if (n == null) {
            return true;
        }

        return isSymmetric(n.getLeft(), n.getRight());
    }

    private static <A extends Comparable<A>> boolean isSymmetric(Node2<A> l, Node2<A> r) {
        if (l == null && r == null) {
            return true;
        }

        if ((l != null && r == null) || (l == null && r != null)) {
            return false;
        }

        return l.getKey().equals(r.getKey())
                && isSymmetric(l.getLeft(), r.getRight())
                && isSymmetric(l.getRight(), r.getLeft());
    }

	/*
     * lca
	 */

    public static <A extends Comparable<A>> Node2<A> lca(Node2<A> n, Node2<A> a, Node2<A> b) {
        // base case
        if (n == null || n.compareTo(a) == 0 || n.compareTo(b) == 0) {
            return n;
        }

        Node2<A> l = lca(n.getLeft(), a, b);
        Node2<A> r = lca(n.getRight(), a, b);

        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        return n;
    }

	/*
     * border
	 */

    public static <A extends Comparable<A>> void border(Node2<A> n) {
        if (n == null) {
            return;
        }

        System.out.print(n.getKey() + ", ");
        left(n.getLeft());
        right(n.getRight());
    }

    private static <A extends Comparable<A>> Node2<A> leaves(Node2<A> n) {
        if (n != null) {
            Node2<A> l = leaves(n.getLeft());
            Node2<A> r = leaves(n.getRight());
            if (l == null && r == null) {
                System.out.print(n.getKey() + ", ");
            }
        }

        return n;
    }

    private static <A extends Comparable<A>> void left(Node2<A> n) {
        if (n == null) {
            return;
        }

        System.out.print(n.getKey() + ", ");
        left(n.getLeft());
        leaves(n.getRight());
    }

    private static <A extends Comparable<A>> void right(Node2<A> n) {
        if (n == null) {
            return;
        }

        leaves(n.getLeft());
        right(n.getRight());
        System.out.print(n.getKey() + ", ");
    }

	/*
     * Node2 to Node2WithCount
	 */

    public static <A extends Comparable<A>> Node2WithCount<A> withCount(Node2<A> n) {
        if (n == null) {
            return null;
        }

        Node2WithCount<A> copy = new Node2WithCount<A>(n.getKey());
        copy.setLeft(withCount(n.getLeft()));
        copy.setRight(withCount(n.getRight()));

        int count = 0;
        if (copy.getLeft() != null) {
            count += copy.getLeft().getCount();
        }
        if (copy.getRight() != null) {
            count += copy.getRight().getCount();
        }

        copy.setCount(count + 1);

        return copy;
    }

	/*
     * kth node in-order traversal
	 */

    public static <A extends Comparable<A>> Node2<A> inOrderKthNodeRec(Node2WithCount<A> n, int k) {
        if (n == null) {
            return null;
        }

        int l = 0;
        if (n.getLeft() != null) {
            l = n.getLeft().getCount();
        }

        if (k <= l) {
            return inOrderKthNodeRec(n.getLeft(), k);
        }

        if (k == l + 1) {
            return n;
        }

        return inOrderKthNodeRec(n.getRight(), k - (l + 1));
    }

    public static <A extends Comparable<A>> Node2<A> inOrderKthNode(Node2WithCount<A> n, int k) {
        while (n != null) {
            int l = 0;
            if (n.getLeft() != null) {
                l = n.getLeft().getCount();
            }

            if (k <= l) {
                n = n.getLeft();
                continue;
            }

            if (k == l + 1) {
                break;
            }

            n = n.getRight();
            k -= l + 1;
        }

        return n;
    }

	/*
     * not yet
	 */

    public static <A extends Comparable<A>> Node2<A> getCanonical(Node2<A> node, Map<Node2<A>, Node2<A>> dic) {
        Node2<A> lc = null;
        if (node.getLeft() != null)
            lc = getCanonical(node.getLeft(), dic);
        Node2<A> rc = null;
        if (node.getRight() != null)
            rc = getCanonical(node.getRight(), dic);
        Node2<A> nc = new Node2<>(node.getKey(), lc, rc);
        if (dic.containsKey(nc))
            return dic.get(nc);
        dic.put(nc, nc);
        return nc;
    }

    public static <A extends Comparable<A>> boolean leaf2Root(Node2<A> procNode, Node2<A> procNodeParent, Node2<A> newRoot) {
        if (procNode == null)
            return false;
        if (procNode.getKey() == newRoot.getKey()) {
            procNode.setLeft(procNodeParent);
            return true;
        }
        if (leaf2Root(procNode.getLeft(), procNode, newRoot)) {
            procNode.setLeft(procNodeParent);
            return true;
        }
        if (leaf2Root(procNode.getRight(), procNode, newRoot)) {
            procNode.setRight(procNodeParent);
            return true;
        }
        return false;
    }
}
