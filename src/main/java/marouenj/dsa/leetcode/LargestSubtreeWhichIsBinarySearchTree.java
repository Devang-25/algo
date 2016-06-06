// http://leetcode.com/2010/11/largest-binary-search-tree-bst-in.html

package marouenj.dsa.leetcode;

import marouenj.dsa.reuse.Node2;

@SuppressWarnings({"unchecked"})
public class LargestSubtreeWhichIsBinarySearchTree {

    public static <A extends Comparable<A>> Object[] largestSearchTree2(Node2<A> curr) {
        if (curr != null) {
            Object[] lft = largestSearchTree2(curr.getLeft());
            Object[] rgt = largestSearchTree2(curr.getRight());

            if (lft == null && rgt == null) { // curr is leaf
                Object[] obj = new Object[5];
                obj[0] = curr; // root of binary search subtree
                obj[1] = curr.getKey(); // min under subtree
                obj[2] = curr.getKey(); // max under subtree
                obj[3] = 1; // card
                obj[4] = true; // merge herafter
                return obj;
            }

            if (lft != null && rgt != null && lft.length == 5 && rgt.length == 5) { // curr is parent of two
                if (((Boolean) lft[4]) && ((Boolean) rgt[4]) && ((A) lft[2]).compareTo(curr.getKey()) < 0 && ((A) rgt[1]).compareTo(curr.getKey()) > 0) { // merge with curr
                    Object[] obj = new Object[5];
                    obj[0] = curr;
                    obj[1] = lft[1];
                    obj[2] = rgt[2];
                    obj[3] = 1 + (Integer) lft[3] + (Integer) rgt[3];
                    obj[4] = true;
                    return obj;
                }
                // pick the largest
                if ((Integer) lft[3] >= (Integer) rgt[3]) {
                    lft[4] = false;
                    return lft;
                }
                rgt[4] = false;
                return rgt;
            }

            if (lft != null && lft.length == 5) { // curr is parent of left only
                if (((A) lft[2]).compareTo(curr.getKey()) < 0) {
                    lft[0] = curr;
                    lft[2] = curr.getKey();
                    lft[3] = 1 + (Integer) lft[3];
                }
                return lft;
            }

            if (rgt != null && rgt.length == 5) { // curr is parent of right only
                if (((A) rgt[1]).compareTo(curr.getKey()) > 0) {
                    rgt[0] = curr;
                    rgt[1] = curr.getKey();
                    rgt[3] = 1 + (Integer) rgt[3];
                }
                return rgt;
            }
        }
        return null;
    }
}
