package marouenj.dsa.reuse;

public class Stack {

    protected Integer[] arr;
    protected int idx_head;

    public Stack(int len) {
        arr = new Integer[len];
        idx_head = -1;
    }

    public boolean isEmpty() {
        return idx_head == -1;
    }

    public boolean isFull() {
        return idx_head == arr.length - 1;
    }

    public boolean push(int e) {
        arr[++idx_head] = e;
        return true;
    }

    public int pop() {
        return arr[idx_head--];
    }

    public int peek() {
        return arr[idx_head];
    }

    public void dump() {
        for (int i = 0; i <= idx_head; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
    }

    public static void main(String args[]) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.dump();
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        stack.dump();
    }
}
