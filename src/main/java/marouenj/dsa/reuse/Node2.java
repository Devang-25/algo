package marouenj.dsa.reuse;

import java.util.Iterator;
import java.util.Stack;

public class Node2<A extends Comparable<A>> implements Comparable<Node2<A>> {

    private A key;
    private Node2<A> left;
    private Node2<A> right;
    private Integer hash;

    public Node2(A key) {
        this(key, null, null);
    }

    public Node2(A key, Node2<A> left, Node2<A> right) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.hash = null;
    }

    @Override
    public int compareTo(Node2<A> that) {
        return this.key.compareTo(that.getKey());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Node2)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        Node2<A> that = (Node2<A>) o;

        return this.key.compareTo(that.getKey()) == 0;
    }

    @Override
    public int hashCode() {
        if (hash != null) {
            return hash;
        }

        int x = 3 * key.hashCode();

        int y = 5;
        if (left != null) {
            y *= left.hashCode();
        }

        int z = 7;
        if (right != null) {
            z *= right.hashCode();
        }

        hash = x + y + z;
        return hash;
    }

    @SuppressWarnings("RedundantCast")
    public int address() {
        return ((Object) this).hashCode();
    }

    public A getKey() {
        return key;
    }

    public void setKey(A key) {
        this.key = key;
    }

    public Node2<A> getLeft() {
        return left;
    }

    public Node2<A> setLeft(Node2<A> left) {
        this.left = left;
        return this.left;
    }

    public Node2<A> getRight() {
        return right;
    }

    public Node2<A> setRight(Node2<A> right) {
        this.right = right;
        return this.right;
    }

    public Node2<A> getPrev() {
        return this.getLeft();
    }

    public Node2<A> setPrev(Node2<A> left) {
        return this.setLeft(left);
    }

    public Node2<A> getNext() {
        return this.getRight();
    }

    public Node2<A> setNext(Node2<A> right) {
        return this.setRight(right);
    }

    public Iterator<A> inOrderIterator() {
        return new InOrderIterator<>(this);
    }

    /**
     * In order iterator
     *
     * @param <B> Type of node key
     */
    private class InOrderIterator<B extends Comparable<B>> implements Iterator<B> {

        private Node2<B> curr;
        private Stack<Node2<B>> stack;

        public InOrderIterator(Node2<B> root) {
            this.curr = root;
            this.stack = new Stack<>();
        }

        @Override
        public boolean hasNext() {
            return curr != null || !stack.empty();
        }

        @Override
        public B next() {
            while (true) {
                if (curr == null) {
                    curr = stack.pop();
                    Node2<B> t = curr;
                    curr = curr.getRight();
                    return t.getKey();
                }

                stack.push(curr);
                curr = curr.getLeft();
            }
        }
    }
}
