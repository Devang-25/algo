// http://leetcode.com/2010/11/largest-binary-search-tree-bst-in_22.html

package marouenj.dsa.leetcode;

import marouenj.dsa.reuse.Node2;

import java.util.Stack;

public class LargestBinarySearchTreeInBinaryTree {

    public static <A extends Comparable<A>> Node2<A> largestSearchTree2(Node2<A> root) {
        if (root == null)
            return null;

        Node2<A> ultimateRoot = null;
        int ultimateCard = 0;

        Stack<Node2<A>> stackOfRoots = new Stack<>();
        Stack<Node2<A>> stackOfChildren = new Stack<>();

        stackOfRoots.add(root);

        while (!stackOfRoots.isEmpty()) {
            Node2<A> currRoot = stackOfRoots.pop();
            stackOfChildren.push(currRoot);
            int currCard = 0;
            while (!stackOfChildren.isEmpty()) {
                Node2<A> currNode = stackOfChildren.pop();
                currCard++;
                if (currNode.getLeft() != null) {
                    if (currNode.getLeft().getKey().compareTo(currNode.getKey()) < 0) {
                        stackOfChildren.push(currNode.getLeft());
                    } else {
                        stackOfRoots.push(currNode.getLeft());
                    }
                }
                if (currNode.getRight() != null) {
                    if (currNode.getRight().getKey().compareTo(currNode.getKey()) > 0) {
                        stackOfChildren.push(currNode.getRight());
                    } else {
                        stackOfRoots.push(currNode.getRight());
                    }
                }
            }
            if (currCard > ultimateCard) {
                ultimateCard = currCard;
                ultimateRoot = currRoot;
            }
        }

        return ultimateRoot;
    }
}
