package marouenj.dsa.reuse;

public class Node2WithCount<T extends Comparable<T>> extends Node2<T> {

    private int count;

    public Node2WithCount(T val) {
        super(val);
        this.count = -1;
    }

    public Node2WithCount(T val, int count) {
        super(val);
        this.count = count;
    }

    @Override
    public Node2WithCount<T> getLeft() {
        return (Node2WithCount<T>) super.getLeft();
    }

    @Override
    public Node2WithCount<T> getRight() {
        return (Node2WithCount<T>) super.getRight();
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
