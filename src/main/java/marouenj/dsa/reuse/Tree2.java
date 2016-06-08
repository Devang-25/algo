package marouenj.dsa.reuse;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class Tree2 {

	/*
     * serialization/deserialization
	 */

    public static <A extends Comparable<A>> Node2<A> TreeFromPreOrderInOrder(A[] in, A[] pre) throws Exception {
        if (in == null || pre == null || in.length == 0 || pre.length == 0 || in.length != pre.length) {
            return null;
        }

        return TreeFromPreOrderInOrderRec(in, 0, in.length - 1, pre, 0, pre.length - 1);
    }

    private static <A extends Comparable<A>> Node2<A> TreeFromPreOrderInOrderRec(A[] in, int in_lo, int in_hi, A[] pre, int pre_lo, int pre_hi) throws Exception {
        if (in_lo > in_hi) {
            return null;
        }

        Node2<A> n = new Node2<A>(pre[pre_lo]);

        int idx = Arrays.indexOf(in, in_lo, in_hi, pre[pre_lo]);
        if (idx == -1) {
            throw new Exception("corrupted tree serialization");
        }

        n.setLeft(TreeFromPreOrderInOrderRec(in, in_lo, idx - 1, pre, pre_lo + 1, pre_lo + (idx - in_lo)));
        n.setRight(TreeFromPreOrderInOrderRec(in, idx + 1, in_hi, pre, pre_lo + (idx - in_lo) + 1, pre_hi));

        return n;
    }

	/*
     * balance
	 */

    public static <A extends Comparable<A>> boolean isBalanced(Node2<A> n) {
        return isBalancedRec(n) != -1;
    }

    private static <A extends Comparable<A>> int isBalancedRec(Node2<A> n) {
        // base case
        if (n == null) {
            return 0;
        }

        int l = isBalancedRec(n.getLeft());
        if (l == -1) {
            return -1;
        }

        int r = isBalancedRec(n.getRight());
        if (r == -1) {
            return -1;
        }

        if (Math.abs(l - r) > 1) {
            return -1;
        }

        return Math.max(l, r) + 1;
    }

    public static <A extends Comparable<A>> Node2<A> withBalancedDescendants(Node2<A> n, int k) {
        Object obj = withKBalancedDescendantsRec(n, k);
        if (obj instanceof Integer) {
            return null;
        }
        @SuppressWarnings("unchecked")
        Node2<A> match = (Node2<A>) obj;
        return match;
    }

    private static <A extends Comparable<A>> Object withKBalancedDescendantsRec(Node2<A> n, int k) {
        if (n == null) {
            return 0;
        }

        Object l = withKBalancedDescendantsRec(n.getLeft(), k);
        if (l instanceof Node2) {
            return l;
        }
        int lcount = (Integer) l;

        Object r = withKBalancedDescendantsRec(n.getRight(), k);
        if (r instanceof Node2) {
            return r;
        }
        int rcount = (Integer) r;

        if (Math.abs(lcount - rcount) > k) {
            return n;
        }

        return lcount + rcount + 1;
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
        if (n == null) {
            return;
        }

        Stack<Node2<A>> stack = new Stack<Node2<A>>();
        stack.push(n);

        while (!stack.isEmpty()) {
            Node2<A> node = stack.pop();
            System.out.print(node.getKey() + ", ");
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public static <A extends Comparable<A>> void preOrderV2(Node2<A> n) {
        Node2<A> curr = n;
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
