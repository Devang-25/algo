package marouenj.dsa.reuse;

public class StackWithMin extends Stack {

    private int idx_min;

    public StackWithMin(int len) {
        super(len);
        idx_min = -1;
    }

    public boolean push(int e) {
        if (idx_head == -1) {
            super.push(e);
            idx_min = idx_head;
        } else if (e < peek()) {
            Arrays.shiftUp(arr, idx_min, idx_head);
            super.push(e);
            idx_min = idx_head;
        } else {
            int e_min = super.pop();
            super.push(e);
            super.push(e_min);
        }
        return true;
    }

    public int pop() {
        int e = 0;
        if (idx_head != idx_min) {
            int e_min = super.pop();
            e = super.pop();
            super.push(e_min);
        } else {
            e = super.pop();
            int idx_min_new = locateNewMin();
            if (idx_min_new != -1) {
                idx_min = idx_min_new;
                Arrays.shiftDown(arr, idx_min, idx_head);
            }
        }
        return e;
    }

    public int locateNewMin() {
        if (idx_head == -1)
            return -1;
        int idx_min_new = 0;
        for (int i = 1; i <= idx_head; i++) {
            if (arr[i] < arr[idx_min_new])
                idx_min_new = i;
        }
        return idx_min_new;
    }

    public static void main(String args[]) {
        StackWithMin stackMin = new StackWithMin(10);
        stackMin.push(5);
        stackMin.dump();
        stackMin.push(6);
        stackMin.dump();
        stackMin.push(8);
        stackMin.dump();
        stackMin.push(4);
        stackMin.dump();
        stackMin.push(4);
        stackMin.dump();
        stackMin.push(3);
        stackMin.dump();
        stackMin.push(4);
        stackMin.dump();
        stackMin.push(2);
        stackMin.dump();
        stackMin.push(4);
        stackMin.dump();
        while (!stackMin.isEmpty()) {
            System.out.println(stackMin.pop());
            stackMin.dump();
        }
    }
}
